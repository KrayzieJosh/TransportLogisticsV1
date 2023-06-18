package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


class LocationControllerTest {

    private static String locationId = "";
    private static String name = "BUCO";
    private static int streetNumber = 17;
    private static String streetName = "Strand rd";
    private static String townOrCity = "Cape Town";
    private static int  areaCode = 213;
    private static Location location = LocationFactory.createLocation(locationId,name,streetNumber,streetName,
            townOrCity,areaCode);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL ="http://localhost:8080/location";

    @Test
    void a_create(){
        String url = baseURL +"/create";
        System.out.println("URL:"+ url);
        ResponseEntity<Location>postResponse = restTemplate.postForEntity(url,location,Location.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(),HttpStatus.OK);

        Location savedLocation = postResponse.getBody();
        assertEquals(savedLocation.getLocationId(),savedLocation.getLocationId());
        System.out.println("Saved data:"+ savedLocation);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read" + location.getLocationId();
        System.out.println("URL:" + url);
        ResponseEntity<Location> response = restTemplate.getForEntity(url,Location.class);
        //assertEquals(location.getLocationId(),response.getBody().getLocationId());

        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Location updated = new Location.Builder()
                .copy(location)
                .setAreaCode(7580)
                .build();
        String url = baseURL + "/update";
        System.out.println("URL" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Location> response = restTemplate.postForEntity(url,updated,Location.class);
        //assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/"+ location.getLocationId();
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