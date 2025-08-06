/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.cusres;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import aero.sita.bordermanagement.uae.gw.bean.IErrorDesc;
import aero.sita.bordermanagement.uae.gw.bean.TransportStageQualifier;
import aero.sita.bordermanagement.uae.gw.config.UAEGatewayRefDataCacheFactory;
import aero.sita.bordermanagement.uae.gw.util.GatewayTransactionUtil;

/**
 * @author SITA
 *
 */
@Component
public class CusresMessageGenerator {
	
	private static final Logger LOG = LoggerFactory.getLogger(CusresMessageGenerator.class);
	
    @Autowired
    @Qualifier("uaeGatewayRefDataCacheFactory")
    private UAEGatewayRefDataCacheFactory refDataCacheFactory;

    
	@Value("${uae.gateway.autoresponder.return-description}")
    private String responseDescription;
	
    /**
     * @param  message
     * @param  delimiters
     * 
     * @return            String
     */
    public String generateCusres(CusresMessage message, Delimiters delimiters, boolean isAutoRespond) {
        StringBuilder sb = new StringBuilder();
        String returnMessage = ""; 

        // Add UNA segment
        sb.append(delimiters.una()).append("\n");

        String e = delimiters.element;
        String c = delimiters.component;
        String s = delimiters.segment;
        int segmentCount = 0;

        // Envelope headers
        sb.append(String.format("UNB%sUNOA:4%s%s%s%s%s%s%s%s", e, e, message.getInterchangeSender(), e,
                message.getInterchangeReceiver(), e, GatewayTransactionUtil.generateEdifactTimestamp(), e,
                message.getInterchangeControlRef())).append(s).append("\n");

        sb.append(String.format("UNG%sCUSRES%s%s%s%s%s%s%s%s%sUN%sD:05B", e, e, message.getInterchangeSender(), e,
                message.getAirlineCode(), e, GatewayTransactionUtil.generateEdifactTimestamp(), e,
                message.getGroupReference(), e, e)).append(s).append("\n");

        sb.append(String.format("UNH%s%s%sCUSRES:D:05B:UN:IATA", e, message.getMessageRef(), e)).append(s).append("\n");
        ++segmentCount;
        sb.append(String.format("BGM%s962", e)).append(s).append("\n");
        ++segmentCount;
        // References - Transaction Number (TN)
        // References - TN and AF handled specially, others in loop
        if (message.getReferences() != null) {
            message.getReferences().stream().filter(ref -> "TN".equals(ref.getQualifier())).findFirst()
                    .ifPresent(ref -> {
                        sb.append(String.format("RFF%sTN%s%s", e, c, ref.value)).append(s).append("\n");
                    });
            ++segmentCount;
        }
        
        if (message.getTransportStageQualifier() != null && CollectionUtils.isNotEmpty(message.getTransportStageQualifier())) {
        	for(TransportStageQualifier tsq : message.getTransportStageQualifier()) {
        		sb.append(String.format("RFF%sAF%s%s", e, c, tsq.getJourneyIdentifier())).append(s).append("\n");
        		++segmentCount;
        		if (tsq.getGrp3() != null && CollectionUtils.isNotEmpty(tsq.getGrp3())) {
        			for (Group3LocationDTM grp3LocDTM : tsq.getGrp3()) {
        				sb.append(String.format("LOC%s%s%s%s", e, grp3LocDTM.getLocation().getQualifier(), e, grp3LocDTM.getLocation().getLocationCode())).append(s).append("\n");
        				++segmentCount;
        				sb.append(String.format("DTM%s%s%s%s%s201", e, grp3LocDTM.getDtm().getDTMFunctionCode() , c, grp3LocDTM.getDtm().getDTMDateTimeStr(), c)).append(s).append("\n");
        				++segmentCount;
        			}
        		}
        	}
        }
        
        for (Group4PaxRef grp4PaxRef : message.getGrp4PaxRef()) {
        	if (!"CLOB".equalsIgnoreCase(message.getResponseFtxMsg())) {
        		sb.append(String.format("ERP%s%S", e, "2")).append(s).append("\n");
        	} else {
        		sb.append(String.format("ERP%s%S", e, "1")).append(s).append("\n");
        	}
        	 ++segmentCount;
        	 if (grp4PaxRef.getReferences() != null) {
	        	 for(Reference ref : grp4PaxRef.getReferences()) {
	        		 sb.append(String.format("RFF%s%s%s%s", e, ref.getQualifier() , c, ref.getValue())).append(s).append("\n");
	        		 ++segmentCount;
	        	 }
        	 }
        	 
        	 if(grp4PaxRef.getAppResponseCode() != null) {
        		 sb.append(String.format("ERC%s%s", e, grp4PaxRef.getAppResponseCode())).append(s).append("\n");
        		 LOG.info("App Response Code  :: "+grp4PaxRef.getAppResponseCode());
					if (grp4PaxRef.getAppResponseCode() != null) {
						IErrorDesc errorCodes = refDataCacheFactory.getErrorCodeByKey(grp4PaxRef.getAppResponseCode());
						if (errorCodes != null) {
							returnMessage = errorCodes.getDesc();
							LOG.info("::" + errorCodes.getDesc());
						}
					}
                 ++segmentCount;
        	 }

             // Error Codes
             if (message.getErrorCodes() != null) {
                 for (String code : message.getErrorCodes()) {
                     sb.append(String.format("ERC%s%s", e, code)).append(s).append("\n");
                     LOG.info("Error code from message      :: "+code);
                     if (code != null) {
                    	if(message.getErrorCodes().indexOf(code) == 0) {
                    		IErrorDesc errorCodes = refDataCacheFactory.getErrorCodeByKey(code);
         					if (errorCodes != null) {
         						returnMessage = errorCodes.getDesc();
         						LOG.info("Error code description from RefData   :: "+returnMessage);
         					}
                    	}
     				}
                     ++segmentCount;
                 }
             }

             if(isAutoRespond) {
            	 returnMessage = message.getResponseFtxMsg();
				} else {
					if (returnMessage.isEmpty()) {
						returnMessage = responseDescription;
					}

				}
             LOG.info("Final FTX response  from  CusresMessageGenerator   :: " + returnMessage);
             sb.append(String.format("FTX%sAAP%s%s%s", e, e, e, e)).append(returnMessage)
                     .append(s).append("\n");
             ++segmentCount;
        }
        /**
         * ERP can be 1 or 2 It should be 1 if the response is for something at message
         * level - like system error, timeout etc. It should be 2 if the issue is
         * related to pax - like validation error, boarding directive etc.
         */

        // Calculate total segments
        
        ++segmentCount; // Added for UNT Segment
        sb.append(String.format("UNT%s%d%s%s", e, segmentCount, e, message.getMessageRef())).append(s).append("\n");
        sb.append(String.format("UNE%s1%s%s", e, e, message.getGroupReference())).append(s).append("\n");
        sb.append(String.format("UNZ%s1%s%s", e, e, message.getInterchangeControlRef())).append(s).append("\n");

        return sb.toString();
    }
}
