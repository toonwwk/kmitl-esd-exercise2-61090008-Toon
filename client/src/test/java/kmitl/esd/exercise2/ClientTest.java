package kmitl.esd.exercise2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client = new Client();
    private RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    private RestTemplate restTemplate = client.restTemplate(restTemplateBuilder);

    @Test
    void restTemplate() {
        assertEquals("org.springframework.web.client.RestTemplate@70cf32e3",
                restTemplate.toString());
    }

    @Test
    void getAll() {
        try {
            CommandLineRunner cmd = client.GetAll(restTemplate);
        } catch (Exception e) {
            assertFalse(true);
        }

    }

    @Test
    void callGetAll() {
    }

    @Test
    void callCreateCustomer() {
    }

    @Test
    void callUpdateCustomer() {
    }

    @Test
    void callDeleteCustomer() {
    }
}