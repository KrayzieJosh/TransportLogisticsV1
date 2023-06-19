package za.ac.cput.controller;
/* NotificationsControllerTest.java
 Entity for the test
 Author: Jameelah Gallo (221110933)
 Date: 19 June 2023
*/
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
import za.ac.cput.domain.Notifications;
import za.ac.cput.factory.NotificationsFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NotificationsControllerTest {


    private static Notifications notifications = NotificationsFactory.createNotification(Helper.generateID(),"The vehicle is on route","ON ROUTE");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/notifications";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Notifications> postResponse = restTemplate.postForEntity(url, notifications, Notifications.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Notifications savedNotifications= postResponse.getBody();

        System.out.println("Saved data: " + notifications);
    }


    @Test
    void b_read() {
        String url = baseURL + "/read/" + notifications.getNotificationId();
        System.out.println("URL: " + url);
        // get
        ResponseEntity<Notifications> response = restTemplate.getForEntity(url, Notifications.class);
        assertEquals(notifications.getNotificationId(), response.getBody().getNotificationId());
        //assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Notifications updated = new Notifications.Builder()
                .copy(notifications)
                .setNotificationStatus("Vehicle stopped!")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // post
        ResponseEntity<Notifications> response = restTemplate.postForEntity(url, updated, Notifications.class);
        assertNotNull(response.getBody());
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