package aero.sita.bordermanagement.uae.gw.config;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;

import com.ibm.mq.jakarta.jms.MQQueue;
import com.ibm.mq.jms.JMSC;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = RequestAdaptorConfiguration.class)
@TestPropertySource(properties = {
        "uae.gateway.app.messageIdSequence=MSG_SEQ",
        "uae.gateway.app.movementIdSequence=MOV_SEQ",
        "uae.gateway.internal.request.queue=DEV.QUEUE.INPUT"
})
class RequestAdaptorConfigurationTest {

    @MockBean
    private DataSource dataSource; // Only mocked to avoid DB connection

    @Autowired
    private OracleSequenceMaxValueIncrementer messageIdSequence;

    @Autowired
    private OracleSequenceMaxValueIncrementer movementIdSequence;

    @Autowired
    private MQQueue appRequestQueue;

    @Test
    void testMessageIdSequenceBeanCreated() {
        assertThat(messageIdSequence).isNotNull();
        assertThat(messageIdSequence.getIncrementerName()).isEqualTo("MSG_SEQ");
    }

    @Test
    void testMovementIdSequenceBeanCreated() {
        assertThat(movementIdSequence).isNotNull();
        assertThat(movementIdSequence.getIncrementerName()).isEqualTo("MOV_SEQ");
    }

    @Test
    void testAppRequestQueueBeanCreated() throws Exception {
        assertThat(appRequestQueue).isNotNull();
        assertThat(appRequestQueue.getBaseQueueName()).isEqualTo("DEV.QUEUE.INPUT");
        assertThat(appRequestQueue.getTargetClient()).isEqualTo(JMSC.MQJMS_CLIENT_NONJMS_MQ);
    }
}
