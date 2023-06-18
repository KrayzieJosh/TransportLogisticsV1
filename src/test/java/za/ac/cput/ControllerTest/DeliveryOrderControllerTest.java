package za.ac.cput.ControllerTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.DeliveryOrderFactory;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeliveryOrderControllerTest {


    static List<MaterialQuote> materialQuotes = new ArrayList<>(Arrays.asList(
            MaterialQuoteFactory.createMaterialQuote(Helper.generateID(), "silver", 14.74, "100 ", 74.25),
            MaterialQuoteFactory.createMaterialQuote(  Helper.generateID(), "Steele", 89.74, "50 ", 41.75)
    ));


    static DeliveryOrder deliveryOrder =
            DeliveryOrderFactory.createDeliveryOrder(Helper.generateID(), "211 sullivan road", "2023-06-11",materialQuotes);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/deliveryOrder";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        // Post
        ResponseEntity<DeliveryOrder> postResponse = restTemplate.postForEntity(url, deliveryOrder, DeliveryOrder.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        DeliveryOrder savedDeliveryOrder = postResponse.getBody();
        assertEquals(savedDeliveryOrder.getDeliveryOrderId(), savedDeliveryOrder.getDeliveryOrderId());
        System.out.println("Saved data: " + savedDeliveryOrder);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + deliveryOrder.getDeliveryOrderId();
        System.out.println("URL: " + url);
        // Get
        ResponseEntity<DeliveryOrder> response = restTemplate.getForEntity(url, DeliveryOrder.class);
        assertEquals(deliveryOrder.getDeliveryOrderId(), response.getBody().getDeliveryOrderId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        DeliveryOrder updated = new DeliveryOrder.Builder()
                .copy(deliveryOrder)
                .setDeliveryAddress("Updated Address")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // Post
        ResponseEntity<DeliveryOrder> response = restTemplate.postForEntity(url, updated, DeliveryOrder.class);
        // assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + deliveryOrder.getDeliveryOrderId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
