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
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.factory.DeliveryEventsFactory;
import za.ac.cput.util.Helper;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DeliveryEventsControllerTest {


    static ArrayList<String> notification;

    static {
        notification = new ArrayList<>();
        notification.add("On route");
        notification.add("Vehicle stopped");
        notification.add("Reached destination");
    }

    static DeliveryEvents deliveryEvent =
            DeliveryEventsFactory.createDeliveryEvents(Helper.generateID(),"John Wattkins","17-06-2023","56 Epping Industria"
                    ,notification);


    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/deliveryEvents";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        // post
        ResponseEntity<DeliveryEvents> postResponse = restTemplate.postForEntity(url, deliveryEvent, DeliveryEvents.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        DeliveryEvents savedDeliveryEvents = postResponse.getBody();
        assertEquals(savedDeliveryEvents.getDeliveryEventId(), savedDeliveryEvents.getDeliveryEventId());
        System.out.println("Saved data: " + savedDeliveryEvents);
    }


    @Test
    void b_read() {
        String url = baseURL + "/read/" + deliveryEvent.getDeliveryEventId();
        System.out.println("URL: " + url);
        // get
        ResponseEntity<DeliveryEvents> response = restTemplate.getForEntity(url, DeliveryEvents.class);
        assertEquals(deliveryEvent.getDeliveryEventId(), response.getBody().getDeliveryEventId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        DeliveryEvents updated = new DeliveryEvents.Builder()
                .copy(deliveryEvent)
                .setDeliveryEventLocation("PardenIsland")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // post
        ResponseEntity<DeliveryEvents> response = restTemplate.postForEntity(url, updated, DeliveryEvents.class);
        //assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + deliveryEvent.getDeliveryEventId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}