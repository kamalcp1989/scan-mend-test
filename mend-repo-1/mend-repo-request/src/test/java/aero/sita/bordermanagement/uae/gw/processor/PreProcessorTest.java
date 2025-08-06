package aero.sita.bordermanagement.uae.gw.processor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.support.DefaultMessage;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aero.sita.bordermanagement.uae.gw.util.MessageConstants;

public class PreProcessorTest {

    private PreProcessor preProcessor;
    private CamelContext context;

    @BeforeEach
    public void setUp() {
        preProcessor = new PreProcessor();
        context = new DefaultCamelContext();
    }

    @Test
    public void testProcess_withCorrelationId() throws Exception {
        Exchange exchange = new DefaultExchange(context);
        DefaultMessage inMessage = new DefaultMessage(context);
        inMessage.setHeader(MessageConstants.JMS_CORRELATION_ID, "TEST_CORR_ID");
        inMessage.setBody("Test Message");

        exchange.setIn(inMessage);

        preProcessor.process(exchange);

        String correlationId = (String) exchange.getMessage().getHeader(MessageConstants.JMS_CORRELATION_ID);
        assertEquals("TEST_CORR_ID", correlationId);
        assertEquals("Test Message", exchange.getMessage().getBody());
    }

    @Test
    public void testProcess_withoutCorrelationId_generatesNewOne() throws Exception {
        Exchange exchange = new DefaultExchange(context);
        DefaultMessage inMessage = new DefaultMessage(context);
        inMessage.setBody("Test Message Without Correlation ID");

        exchange.setIn(inMessage);

        preProcessor.process(exchange);

        String newCorrelationId = (String) exchange.getMessage().getHeader(MessageConstants.JMS_CORRELATION_ID);
        assertNotNull(newCorrelationId);
        assertEquals(newCorrelationId, exchange.getMessage().getHeader(MessageConstants.MESSAGE_ID));
        assertEquals("Test Message Without Correlation ID", exchange.getMessage().getHeader(MessageConstants.PAX_LIST_MSG_HEADER));
    }

    @Test
    public void testGenerateUniqueId_formatCheck() {
        String id = preProcessor.generateUniqueId();
        assertNotNull(id);
        assertTrue(id.matches("\\d{17}"), "ID should match 17-digit timestamp format");
    }
}
