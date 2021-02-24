package kmitl.esd.exercise2;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kmitl.esd.exercise2.CustomerDTO;
import java.util.Collections;

@SpringBootApplication
public class Client {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Client.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8089"));
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner GetAll(RestTemplate restTemplate) throws Exception {
        return args -> {
            String response = callGetAll(restTemplate);
            log.info(String.format("GET all customers info: " + response));
            CustomerDTO createCustomer = callCreateCustomer(restTemplate);
            log.info("CREATE new customer: " + createCustomer.toString());
            CustomerDTO updateCustomer=callUpdateCustomer(restTemplate);
            log.info("UPDATE existing customer: " + updateCustomer.toString());
            ResponseEntity responseEntity =callDeleteCustomer(restTemplate,"2");
            String deleteResponse = callGetAll(restTemplate);
            log.info("DELETE existing customer: " +deleteResponse);

        };
    }

    /**
     * get all customers info
     */
    String callGetAll(RestTemplate restTemplate) {
        StringBuffer url = new StringBuffer("http://localhost:8080/customer");
        String respString = restTemplate.getForObject(
                url.toString(), String.class);
        return respString;
    }

    /**
     * create new customer
     */

    CustomerDTO callCreateCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customers = new JSONObject();
        customers.put("id",2);
        customers.put("name","Toon");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(customers.toString(), headers);

        ResponseEntity<CustomerDTO> response = restTemplate.exchange("http://localhost:8080/customer", HttpMethod.POST, request, CustomerDTO.class);
        return response.getBody();

    }

    /**
     * update existind customer info
     */

    CustomerDTO callUpdateCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customers = new JSONObject();
        customers.put("id",2L);
        customers.put("name","Toonkung");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(customers.toString(), headers);
        ResponseEntity<CustomerDTO> response = restTemplate.exchange("http://localhost:8000/customer", HttpMethod.PUT, request, CustomerDTO.class);
        return response.getBody();

    }

    ResponseEntity<String> callDeleteCustomer(RestTemplate restTemplate, String customerId) {
        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8000/customer/" + customerId,HttpMethod.DELETE,null,String.class);
        return response;
    }

}

