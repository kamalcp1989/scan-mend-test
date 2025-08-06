package aero.sita.bordermanagement.uae.gw.listener;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import aero.sita.bordermanagement.uae.gw.GatewayRequestAdapterApplication;
import aero.sita.bordermanagement.uae.gw.bean.IAirlineEnrollment;
import aero.sita.bordermanagement.uae.gw.config.UAEGatewayRefDataCacheFactory;
import aero.sita.bordermanagement.uae.gw.processor.APIObjectSaveTransactionProcessor;
import aero.sita.bordermanagement.uae.gw.processor.APPRequestProcessor;
import aero.sita.bordermanagement.uae.gw.processor.AutoResponderProcessor;
import aero.sita.bordermanagement.uae.gw.processor.GatewayAuditProcessor;
import aero.sita.bordermanagement.uae.gw.processor.PAXListToAPIObjectConverterProcessor;
import aero.sita.bordermanagement.uae.gw.processor.PreProcessor;
import model.api.APIMessage;

@ExtendWith(SpringExtension.class)
@CamelSpringBootTest
@SpringBootTest(classes = {
        GatewayRequestAdapterApplication.class,
        GatewayExternalPaxListRouteTest.TestConfig.class
})
public class GatewayExternalPaxListRouteTest {

    @Configuration
    static class TestConfig {

    	@Bean
        public GatewayExternalPaxListRoute route() {
            return new GatewayExternalPaxListRoute();
        }
    }

    @Autowired
    private CamelContext camelContext;

    @Autowired
    private ProducerTemplate producerTemplate;

    @MockBean
    private PreProcessor preProcessor;

    @MockBean
    private PAXListToAPIObjectConverterProcessor paxListToAPIObjectConverterProcessor;

    @MockBean
    private APIObjectSaveTransactionProcessor apiObjectSaveTransactionProcessor;

    @MockBean
    private APPRequestProcessor appRequestProcessor;

    @MockBean
    private GatewayAuditProcessor gatewayAuditProcessor;

    @MockBean
    private AutoResponderProcessor autoResponderProcessor;

    @MockBean
    private UAEGatewayRefDataCacheFactory uaeGatewayRefDataCacheFactory;

    @MockBean
    private IAirlineEnrollment airlineEnrollment;

    @BeforeEach
    public void setup() throws Exception {
        when(airlineEnrollment.getSenderSystem()).thenReturn("DCS1");
        when(airlineEnrollment.getAirlineCodes()).thenReturn("EK");
        when(airlineEnrollment.getServiceRequestQueue()).thenReturn("direct:input");
        when(airlineEnrollment.getServiceResponseQueue()).thenReturn("direct:response");
        when(airlineEnrollment.getConcurrentConsumer()).thenReturn(1L);
        when(airlineEnrollment.getMaxConcurrentConsumer()).thenReturn(1L);
        when(airlineEnrollment.isAutoResponder()).thenReturn(true);

        when(uaeGatewayRefDataCacheFactory.getAllEnrolledSenderSystem()).thenReturn(List.of(airlineEnrollment));

        // Use ModelCamelContext to apply advice
        ModelCamelContext modelCamelContext = (ModelCamelContext) camelContext;

        AdviceWith.adviceWith(modelCamelContext, "id_DCS1", builder -> {
            builder.weaveByToUri("direct:auto-responder").replace().to("mock:auto-responder");
            builder.weaveByToUri("direct:gw-audit").replace().to("mock:audit");
        });
    }

    @Test
    public void testAutoResponderFlow() throws Exception {
        Exchange exchange = new DefaultExchange(camelContext);
        exchange.getIn().setBody("dummy PAXLST message");
        exchange.getIn().setHeader("CamelFileName", "test.msg");

        // Prepare mock response for converter
        APIMessage mockApiMsg = new APIMessage();
        mockApiMsg.getErrorCodes().add("ERR01");

        doAnswer(invocation -> {
            Exchange ex = invocation.getArgument(0, Exchange.class);
            ex.getMessage().setBody(mockApiMsg);
            return null;
        }).when(paxListToAPIObjectConverterProcessor).process(any(Exchange.class));

        producerTemplate.send("direct:input", exchange);

        verify(preProcessor, atLeastOnce()).process(any());
        verify(paxListToAPIObjectConverterProcessor, atLeastOnce()).process(any());
        verify(autoResponderProcessor, atLeastOnce()).process(any());
    }
}
