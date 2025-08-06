package aero.sita.bordermanagement.uae.gw.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UAEGatewayOracleConfigBeanTest {
	
    @Test
    public void testGettersAndSetters() {
    	UAEGatewayOracleConfigBean bean = new UAEGatewayOracleConfigBean();
    	String driverClassName = "OracleDriver";
    	String password = "password";
    	String url = "url";
    	String username = "jdbc";
    	
    	bean.setDriverClassName(driverClassName);
    	bean.setPassword(password);
    	bean.setUrl(url);
    	bean.setUsername(username);
    	
    	
    	Assertions.assertEquals(bean.getDriverClassName(), driverClassName);
    	Assertions.assertEquals(bean.getPassword(), password);
    	Assertions.assertEquals(bean.getUrl(), url);
    	Assertions.assertEquals(bean.getUsername(), username);
    	
    }

}
