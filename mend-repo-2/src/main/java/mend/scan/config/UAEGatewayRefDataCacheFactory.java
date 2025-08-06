package aero.sita.bordermanagement.uae.gw.config;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aero.sita.bordermanagement.uae.gw.bean.CountryUsageType;
import aero.sita.bordermanagement.uae.gw.bean.IAirlineEnrollment;
import aero.sita.bordermanagement.uae.gw.bean.ICountry;
import aero.sita.bordermanagement.uae.gw.bean.IErrorDesc;
import aero.sita.bordermanagement.uae.gw.bean.ILocation;
import aero.sita.bordermanagement.uae.gw.bean.IOperator;
import aero.sita.bordermanagement.uae.gw.bean.IStatusCodeDesc;
import aero.sita.bordermanagement.uae.gw.bean.LocationUsageType;
import aero.sita.bordermanagement.uae.gw.dao.AirlineEnrollmentDAOImpl;
import aero.sita.bordermanagement.uae.gw.dao.RefDataDAOImpl;
import jakarta.annotation.PostConstruct;



@Component("uaeGatewayRefDataCacheFactory")
public class UAEGatewayRefDataCacheFactory {
	
	private Map<String, IAirlineEnrollment> airlineEnrollmentMap;
	
	private Map<String, IErrorDesc> errorDescMap;
	
	private Map<String, IStatusCodeDesc> statusCodeDescMap;
	
	private Map<String, ICountry> countryMap;
	
	private Map<String, IOperator> operatorMap;
	
	private Map<String, ILocation> locationMap;
	
    /**
     * airlineEnrollmentConfig : AirlineEnrollmentConfig Configuration bean for
     * managing airline-specific settings and enrollment behavior.
     */
    @Autowired
    private AirlineEnrollmentDAOImpl airlineEnrollmentDaoImpl;
    
    @Autowired
    private RefDataDAOImpl refDataDaoImpl;
    
    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(UAEGatewayRefDataCacheFactory.class);
	
	@PostConstruct
	public void loadCache() {
		
		Date startDatetime = new Date();
		
		LOG.info("**********************  Start Cache Loading  *********************");
		
		List<IAirlineEnrollment> airlineEnrollments = airlineEnrollmentDaoImpl.getAllEnrolledAirlines();
		this.airlineEnrollmentMap = Collections.unmodifiableMap(airlineEnrollments.stream().collect(Collectors.toMap(IAirlineEnrollment :: getSenderSystem, cfg -> cfg, (existing, replacement) -> existing)));

		List<IStatusCodeDesc> statusCodeDesc = refDataDaoImpl.getAllStatusCode();
		this.statusCodeDescMap = Collections.unmodifiableMap(statusCodeDesc.stream().collect(Collectors.toMap(IStatusCodeDesc :: getMessageCode, cfg -> cfg, (existing, replacement) -> existing)));
		
		List<IErrorDesc> errorCodeDesc = refDataDaoImpl.getAllErrorCodeDesc();
		this.errorDescMap = Collections.unmodifiableMap(errorCodeDesc.stream().collect(Collectors.toMap(IErrorDesc :: getErrorCode, cfg -> cfg, (existing, replacement) -> existing)));
		
		List<ICountry> countryList = refDataDaoImpl.getAllCountries();
		this.countryMap = Collections.unmodifiableMap(countryList.stream().collect(Collectors.toMap(ICountry :: getIsoCode3, cfg -> cfg, (existing, replacement) -> existing)));
		
		List<IOperator> operatorList = refDataDaoImpl.getAllOperators();
		this.operatorMap = Collections.unmodifiableMap(operatorList.stream().collect(Collectors.toMap(IOperator :: getIataCode, cfg -> cfg, (existing, replacement) -> existing)));
		
		List<ILocation> locationList = refDataDaoImpl.getAllLocations();
		this.locationMap = Collections.unmodifiableMap(locationList.stream().collect(Collectors.toMap(ILocation :: getIataCode, cfg -> cfg, (existing, replacement) -> existing)));
		
		LOG.info("******************* End Cache Loading ************************** ");
		Date endDateTime = new Date();
		LOG.info("Total time take to load the cache ::"+ (endDateTime.getTime() - startDatetime.getTime()));
	}
	
	public List<IAirlineEnrollment> getEnrolledSenderSystem(List<String> senderSystemCodeList) {
		return senderSystemCodeList.stream().map(this.airlineEnrollmentMap :: get).filter(Objects::nonNull).collect(Collectors.toList());
	}
	
	public List<IAirlineEnrollment> getAllEnrolledSenderSystem() {
		return this.airlineEnrollmentMap.values().stream().collect(Collectors.toList());
	}
	
	public IStatusCodeDesc getStatusCodeByKey(final String key) {
		return this.statusCodeDescMap.get(key);
	}
	
	public IErrorDesc getErrorCodeByKey(final String key) {
		return this.errorDescMap.get(key);
	}
	
	public ICountry getCountryByKey(final String key) {
		return this.countryMap.get(key);
	}
	
	public IOperator getOperatorByKey(final String key) {
		return this.operatorMap.get(key);
	}
	
	public ILocation getLocationByKey(final String key) {
		ILocation locationFromMap = null;
		if (3 == key.length()) {
			locationFromMap = this.locationMap.get(key);
		} if (4 == key.length()) {
			//Need to include implement for ICAO Code
		} if (5 == key.length()) {
			//Need to include implement for UNLO Code
		}
		return locationFromMap;
	}
	
	public boolean isUAEPort(final String key) {
		ILocation location = getLocationByKey(key);
		if (location != null && location.getCountry() != null) {
			return "ARE".equals(location.getCountry().getIsoCode3());
		} else {
			return false;
		}
	}

	public boolean validateOperator(String carrierIdentifier) {
		if(operatorMap.containsKey(carrierIdentifier)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean validateLocation(String locationNameCode) {
		if(locationMap == null) {
			return true;
		}
		if(locationMap.containsKey(locationNameCode)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean validateCountryOfResidence(String locationNameCode) {
		ICountry iCountry = countryMap.get(locationNameCode); 
		if(iCountry.getUsageType().contains(CountryUsageType.COUNTRY_OF_ORIGIN)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean validateCountryOfBirth(String locationNameCode) {
		ICountry iCountry = countryMap.get(locationNameCode); 
		if(iCountry.getUsageType().contains(CountryUsageType.COUNTRY_OF_BIRTH)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean validateNationality(String nationalityNameCode) {
		ICountry iCountry = countryMap.get(nationalityNameCode); 
		if(iCountry.getUsageType().contains(CountryUsageType.NATIONALITY)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean validateCountryOfIssue(String locationNameCode) {
		ICountry iCountry = countryMap.get(locationNameCode); 
		if(iCountry.getUsageType().contains(CountryUsageType.COUNTRY_OF_ISSUE)) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getCountryByLocation(String location) {
		ILocation locationByKey = getLocationByKey(location); 
		if(locationByKey != null) {
			if(locationByKey.getCountry() != null) {
				return locationByKey.getCountry().getIsoCode3();
			}else {
				return "";
			}
		}else {
			return "";
		}
	}
}
