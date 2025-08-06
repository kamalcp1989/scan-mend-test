package aero.sita.bordermanagement.uae.gw.processor;

import aero.sita.bordermanagement.uae.gw.bean.GatewayTransaction;
import aero.sita.bordermanagement.uae.gw.bean.TransportStageQualifier;
import aero.sita.bordermanagement.uae.gw.dao.GatewayTransactionDAOImpl;
import model.api.APIMessage;
import model.paxlist.PaxListMessage;
import model.service.BgmBeginningOfMessage;
import model.service.C106DocumentMessageIdentification;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;


public class APIObjectSaveTransactionProcessorTest {
	

    @InjectMocks
    private APIObjectSaveTransactionProcessor processor;

    @Mock
    private GatewayTransactionDAOImpl gatewayTransactionDAOImpl;

    @Mock
    private OracleSequenceMaxValueIncrementer messageIdSequence;
    
    @Mock
    private Exchange exchange;

    @Mock
    private Message inMessage;

    @Mock
    private Message outMessage;

    @Mock
    private APIMessage apiMessage;
    
    @Mock
    private PaxListMessage paxListMessage;

    @Mock
    private BgmBeginningOfMessage bgm;
    
    @Mock
    private C106DocumentMessageIdentification docMsgId;

    @Captor
    private ArgumentCaptor<List<GatewayTransaction>> txListCaptor;
    
    
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        
        Field originIdField = APIObjectSaveTransactionProcessor.class.getDeclaredField("originID");
        originIdField.setAccessible(true);
        originIdField.set(processor, "ORIGID");
        
        when(exchange.getIn()).thenReturn(inMessage);
        when(exchange.getOut()).thenReturn(outMessage);

        when(inMessage.getBody(APIMessage.class)).thenReturn(apiMessage);
        when(apiMessage.getMessage()).thenReturn(paxListMessage);
        when(paxListMessage.getBgm()).thenReturn(bgm);
        when(bgm.getDocumentMessageIdentification()).thenReturn(docMsgId);
        when(docMsgId.getDocumentIdentifier()).thenReturn("SC");

        when(inMessage.getHeader(eq("JMSCorrelationID"), eq(String.class))).thenReturn("correlation123");
        when(messageIdSequence.nextStringValue()).thenReturn("123456");
        when(gatewayTransactionDAOImpl.getListOfExpectedPassengerId(anyInt(), anyString()))
                .thenReturn(List.of(111L)); // only one transaction for test
    }
    
    
    @Test
    void testProcess_SavesTransactionCorrectly() throws Exception {
        processor.process(exchange);

        verify(gatewayTransactionDAOImpl).insertOrUpdate(txListCaptor.capture(), anyList(), eq("SC"));
        List<GatewayTransaction> capturedTxList = txListCaptor.getValue();

        assertNotNull(capturedTxList);
        assertEquals(1, capturedTxList.size());
        assertEquals("correlation123", capturedTxList.get(0).getCorrelationId());
        assertEquals("ORIGID123456   ", capturedTxList.get(0).getMessageIdentifier());
        assertEquals(111L, capturedTxList.get(0).getExpectedPassengerId());
    }
    
    @Test
    void testProcess_WhenXR_MessageType() throws Exception {
        when(docMsgId.getDocumentIdentifier()).thenReturn("XR");

        processor.process(exchange);

        verify(gatewayTransactionDAOImpl).insertOrUpdate(anyList(), anyList(), eq("XR"));
    }
    
    @Test
    void testProcess_WhenCLOB_MessageType() throws Exception {
        when(docMsgId.getDocumentIdentifier()).thenReturn("CLOB");

        processor.process(exchange);

        verify(gatewayTransactionDAOImpl).insertOrUpdate(anyList(), anyList(), eq("SC"));
        // You could further assert via captors or mocks that `messageMetaDataProcessingForFlightClosure()` path is taken
    }
    
    

}
