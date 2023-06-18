package za.ac.cput.controller;

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
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.domain.User;
import za.ac.cput.factory.DeliveryHistoryFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeliveryHistoryControllerTest {

    static User user1 = UserFactory.createUser(Helper.generateID(), "Lyle","Andre", "Esau", "0610560987","lyle@gmail.com", "Code B");
    static User user2 = UserFactory.createUser(Helper.generateID(), "Jack","Wayne", "Adams", "0610956987","Jack@gmail.com", "Code B");
    static ArrayList<User> listOfUsers = new ArrayList<User>(Arrays.asList( user1, user2));

    static DeliveryHistory deliveryHistory =
            DeliveryHistoryFactory.createNewDeliveryHistory(Helper.generateID(), listOfUsers, Helper.generateID());

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/deliveryHistory";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        // post
        ResponseEntity<DeliveryHistory> postResponse = restTemplate.postForEntity(url, deliveryHistory, DeliveryHistory.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        DeliveryHistory savedDeliveryHistory = postResponse.getBody();
        assertEquals(savedDeliveryHistory.getDeliveryOrderId(), savedDeliveryHistory.getDeliveryOrderId());
        System.out.println("Saved data: "+ savedDeliveryHistory);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + deliveryHistory.getDeliveryOrderId();
        System.out.println("URL: " + url);
        // get
        ResponseEntity<DeliveryHistory> response = restTemplate.getForEntity(url, DeliveryHistory.class);
        assertEquals(deliveryHistory.getDeliveryOrderId(),response.getBody().getDeliveryOrderId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        DeliveryHistory updated = new DeliveryHistory.Builder()
                .copy(deliveryHistory)
                .setVehicleId(Helper.generateID())
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // post
        ResponseEntity<DeliveryHistory> response = restTemplate.postForEntity(url, updated, DeliveryHistory.class);
        //assertNotNull(response.getBody());
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
