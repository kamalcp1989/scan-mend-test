package aero.sita.bordermanagement.uae.gw;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GatewayRequestAdapterApplicationTest {

    @Test
    void contextLoads() {
        // This ensures the Spring application context starts successfully
    }

    @Test
    void testCreateMethodReturnsBuilderWithCorrectSources() {
        SpringApplicationBuilder builder = GatewayRequestAdapterApplication.create();
        assertThat(builder).isNotNull();
        assertThat(builder.application().getAllSources())
            .anyMatch(source -> source instanceof Class &&
                ((Class<?>) source).equals(GatewayRequestAdapterApplication.class));
    }

    @Test
    void testMainMethodDoesNotThrow() {
        assertDoesNotThrow(() -> {
            GatewayRequestAdapterApplication.main(new String[] {});
        });
    }
}
