package aero.sita.bordermanagement.uae.gw.processor;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.HashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import aero.sita.bordermanagement.uae.gw.config.UAEGatewayRefDataCacheFactory;
import aero.sita.bordermanagement.uae.gw.service.GatewayService;
import model.api.APIMessage;
import model.ediwrapper.EDIHeader;
import model.ediwrapper.EDITrailer;
import model.paxlist.PaxListMessage;
import model.service.S001SyntaxIdentifier;
import model.service.S002InterchangeSender;
import model.service.S004DateAndTimeOfPreparation;
import model.service.UnbInterchangeHeader;
import model.service.UngGroupHeader;
import model.service.UnhMessageHeader;

@ExtendWith(SpringExtension.class)
public class PAXListToAPIObjectConverterProcessorTest {
	
    @InjectMocks
    private PAXListToAPIObjectConverterProcessor processor;

    @Mock
    private GatewayService gatewayService;

    @Mock
    private UAEGatewayRefDataCacheFactory refDataCacheFactory;

    @Mock
    private Exchange exchange;

    @Mock
    private Message inMessage;

    @Mock
    private Message outMessage;

    private static final String SAMPLE_PAXLIST = "UNB+UNOA:4+EK+ICPUAE+250702:1610+1100660'UNG+PAXLST+EK+ICPUAE+250702:1610+1100660+UN+D:05B'UNH+MSG110660+PAXLST:D:05B:UN:IATA'BGM+745'RFF+TN:YG5000660:1'NAD+MS+++DAVIDSON:ROBERT'COM+202 628 9292:TE+202 628 4998:FX+davidsonr@iata.org:EM'TDT+20+EY0256+++EY'LOC+22+LHR'DTM+189:2507031030:201'LOC+87+AUH'DTM+232:2507032235:201'NAD+FL+++WILLIAMS:JOHN DONALD'ATT+2++M'DTM+329:010510'LOC+22+AUH'LOC+174+GBR'LOC+178+LHR'LOC+179+AUH'LOC+180+NZL'COM+202 628 9292:TE+202 628 4998:FX+TESTEMAIL@sita.aero:EM'NAT+2+ARE'RFF+AVF:F11660'RFF+ABO:PAXREF110660'DOC+I+784200915487611'DTM+36:300803'DTM+182:090731'LOC+91+GBR'CNT+42:01'UNT+36+MSG110660'UNE+1+1100660'UNZ+1+1100660'";

    
    @BeforeEach
    void setup() {
        when(exchange.getIn()).thenReturn(inMessage);
        when(exchange.getOut()).thenReturn(outMessage);
        when(inMessage.getBody(String.class)).thenReturn(SAMPLE_PAXLIST);
        when(inMessage.getHeaders()).thenReturn(new HashMap<>());
    }
    
    @Test
    void shouldReturnEarlyOnSyntaxValidationError() throws Exception {
        APIMessage syntaxValidated = new APIMessage();
        syntaxValidated.getErrorCodes().add("E001");

        when(gatewayService.syntaxValidation(SAMPLE_PAXLIST)).thenReturn(syntaxValidated);

        processor.process(exchange);

        verify(exchange.getIn()).setBody(syntaxValidated);
        verify(exchange.getOut()).setHeaders(anyMap());
        verify(gatewayService, never()).parse(any());
    }
    
    @Test
    void shouldReturnEarlyOnDataValidationError() throws Exception {
        APIMessage syntaxValidated = new APIMessage();
        

        APIMessage parsedMessage = new APIMessage();
        parsedMessage.getErrorCodes().add("E002"); // has data error

        when(gatewayService.syntaxValidation(SAMPLE_PAXLIST)).thenReturn(syntaxValidated);
        when(gatewayService.parse(SAMPLE_PAXLIST)).thenReturn(parsedMessage);

        processor.process(exchange);

        verify(exchange.getIn()).setBody(parsedMessage);
        verify(exchange.getOut()).setHeaders(anyMap());
    }
    
    
    @Test
    void shouldContinueIfNoErrorsAndRefDataValid() throws Exception {
        APIMessage syntaxValidated = new APIMessage();
        

        APIMessage parsedMessage = new APIMessage();
        
        /**
         * EDI Header
         */
        EDIHeader ediHeader = new EDIHeader();
        
        S002InterchangeSender sender = new S002InterchangeSender();
        sender.setInterchangeSenderIdentification("SENDER-ID");
        S004DateAndTimeOfPreparation prepTime = new S004DateAndTimeOfPreparation();
        prepTime.setDate(new String("250624"));
        prepTime.setTime(new String("1045"));
        
        UnbInterchangeHeader unbInterchangeHeader = new UnbInterchangeHeader();
        unbInterchangeHeader.setInterchangeControlReference("ICR-456");
        unbInterchangeHeader.setDateAndTimeOfPreparation(prepTime);
        unbInterchangeHeader.setInterchangeSender(sender);
        
        S001SyntaxIdentifier syntaxIdentifier = new S001SyntaxIdentifier();
        syntaxIdentifier.setSyntaxIdentifier("1234");
        syntaxIdentifier.setSyntaxVersionNumber("1");
        unbInterchangeHeader.setSyntaxIdentifier(syntaxIdentifier);
        ediHeader.setUnb(unbInterchangeHeader);
        
        UngGroupHeader ung = new UngGroupHeader();
        ung.setApplicationRecipientIdentification(null);
        
        
        ediHeader.setUng(ung);
        UnhMessageHeader unh = new UnhMessageHeader();
        ediHeader.setUnh(unh);
        ediHeader.setUnb(unbInterchangeHeader);
        ediHeader.setUng(ung);
        ediHeader.setUnh(unh);
        parsedMessage.setHeader(ediHeader);
        
        /**
         * EDI PAXLST
         */
        PaxListMessage paxlst = new PaxListMessage();
        parsedMessage.setMessage(paxlst);
        
        /**
         * EDI Trailer
         */
        EDITrailer trailer = new EDITrailer();
        parsedMessage.setTrailer(trailer);
        
        

        when(gatewayService.syntaxValidation(SAMPLE_PAXLIST)).thenReturn(syntaxValidated);
        when(gatewayService.parse(SAMPLE_PAXLIST)).thenReturn(parsedMessage);

        // You may mock or stub methods on refDataCacheFactory as required here

        processor.process(exchange);

        verify(exchange.getIn()).setBody(parsedMessage);
        verify(exchange.getOut()).setHeaders(anyMap());
    }
}
