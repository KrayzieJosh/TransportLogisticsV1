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
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MaterialQuoteControllerTest {

    static MaterialQuote materialQuote =
            MaterialQuoteFactory.createMaterialQuote(Helper.generateID(), "Material 1", 100,"100",4.00);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/materialQuote";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        // Post
        ResponseEntity<MaterialQuote> postResponse = restTemplate.postForEntity(url, materialQuote, MaterialQuote.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        MaterialQuote savedMaterialQuote = postResponse.getBody();
        assertEquals(savedMaterialQuote.getMaterialQuoteId(), savedMaterialQuote.getMaterialQuoteId());
        System.out.println("Saved data: " + savedMaterialQuote);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + materialQuote.getMaterialQuoteId();
        System.out.println("URL: " + url);
        // Get
        ResponseEntity<MaterialQuote> response = restTemplate.getForEntity(url, MaterialQuote.class);
        assertEquals(materialQuote.getMaterialQuoteId(), response.getBody().getMaterialQuoteId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        MaterialQuote updated = new MaterialQuote.Builder()
                .copy(materialQuote)
                .setMaterialName("Updated Material")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // Post
        ResponseEntity<MaterialQuote> response = restTemplate.postForEntity(url, updated, MaterialQuote.class);
        // assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + materialQuote.getMaterialQuoteId();
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
