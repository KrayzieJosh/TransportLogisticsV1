package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.GPS;
import za.ac.cput.factory.GPSFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


class GPSControllerTest {

    private static String tripId = "";
    private static String startLocationId = "214-568-74";
    private static String storeLocationId = "456-789-654";

    private static GPS gps = GPSFactory.createGPS(tripId,startLocationId,storeLocationId);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL ="http://localhost:8080/gps";

    @Test
    void a_create(){
        String url = baseURL +"/create";
        System.out.println("URL:"+ url);
        ResponseEntity<GPS>postResponse = restTemplate.postForEntity(url,gps,GPS.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(),HttpStatus.OK);

        GPS savedLocation = postResponse.getBody();
        assertEquals(savedLocation.getTripId(),savedLocation.getTripId());
        System.out.println("Saved data:"+ savedLocation);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read" + gps.getTripId();
        System.out.println("URL:" + url);
        ResponseEntity<GPS> response = restTemplate.getForEntity(url,GPS.class);
        //assertEquals(gps.getTripId(),response.getBody().getTripId());

        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        GPS updated = new GPS.Builder()
                .copy(gps)
                .setStoreLocationId("147-852-624-1")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<GPS> response = restTemplate.postForEntity(url,updated,GPS.class);
        //assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/"+ gps.getTripId();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL +"/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}