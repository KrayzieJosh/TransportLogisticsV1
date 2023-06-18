package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Tracking;
import za.ac.cput.factory.TrackingFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


class TrackingControllerTest {

    private static String tripId = "";
    private static int stops = 4;
    private static int detours = 0;

    private static Tracking tracking = TrackingFactory.createTracker(tripId,stops,detours);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL ="http://localhost:8080/tracking";

    @Test
    void a_create(){
        String url = baseURL +"/create";
        System.out.println("URL:"+ url);
        ResponseEntity<Tracking>postResponse = restTemplate.postForEntity(url,tracking,Tracking.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(),HttpStatus.OK);

        Tracking savedLocation = postResponse.getBody();
        assertEquals(savedLocation.getTripId(),savedLocation.getTripId());
        System.out.println("Saved data:"+ savedLocation);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read" + tracking.getTripId();
        System.out.println("URL:" + url);
        ResponseEntity<Tracking> response = restTemplate.getForEntity(url,Tracking.class);
        //assertEquals(gps.getTripId(),response.getBody().getTripId());

        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Tracking updated = new Tracking.Builder()
                .copy(tracking)
                .setStops(7)
                .build();
        String url = baseURL + "/update";
        System.out.println("URL" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Tracking> response = restTemplate.postForEntity(url,updated,Tracking.class);
        //assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/"+ tracking.getTripId();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL +"/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}