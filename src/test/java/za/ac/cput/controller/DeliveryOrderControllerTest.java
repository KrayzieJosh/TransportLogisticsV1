package za.ac.cput.controller;

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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/*
   Entity for DeliverOrderControllerTest
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DeliveryOrderControllerTest {
    private static List<MaterialQuote> materialQuotes = Arrays.asList(MaterialQuoteFactory.createMaterialQuote(
            Helper.generateID(),"Wood",11,"12",12)

    );
    static DeliveryOrder deliveryOrder = DeliveryOrderFactory.createDeliveryOrder(
            "1",
            "123 Main Street",
            "2023-09-15",
            materialQuotes
    );

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/deliveryOrder";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<DeliveryOrder> postResponse = restTemplate.postForEntity(url, deliveryOrder, DeliveryOrder.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        DeliveryOrder createdDeliveryOrder = postResponse.getBody();

        assertNotNull(createdDeliveryOrder);
        assertEquals(deliveryOrder.getDeliveryOrderId(), createdDeliveryOrder.getDeliveryOrderId());

        System.out.println("Saved data: " + createdDeliveryOrder);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + deliveryOrder.getDeliveryOrderId();
        System.out.println("URL: " + url);
        ResponseEntity<DeliveryOrder> response = restTemplate.getForEntity(url, DeliveryOrder.class);
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {

        DeliveryOrder updated = new DeliveryOrder.DeliveryOrderBuilder()
                .copy(deliveryOrder)
                .setDeliveryAddress("12 Kanal Walk")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // Post
        ResponseEntity<DeliveryOrder> response = restTemplate.postForEntity(url, updated, DeliveryOrder.class);
    }

    @Disabled
    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + deliveryOrder.getDeliveryOrderId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
