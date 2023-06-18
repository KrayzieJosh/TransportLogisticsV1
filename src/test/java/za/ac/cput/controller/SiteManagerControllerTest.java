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
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SiteManagerControllerTest {
    static List<Project> projects= Arrays.asList(ProjectFactory.createProject(Helper.generateID(),"Project1","In progress"));
    static SiteManager manager= SiteManagerFactory.createSiteManager(
            Helper.generateID(),"Foreman",projects);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/sitemanager";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<SiteManager> postResponse=restTemplate.postForEntity(url,manager,SiteManager.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        SiteManager siteManager =postResponse.getBody();
        assertEquals(siteManager.getUserId(),siteManager.getUserId());

        assertNotNull(siteManager);
        System.out.println("Saved data: " + siteManager);
    }

    @Test
    void b_read() {
        String url=baseURL + "/read/"+ manager.getUserId();
        System.out.println("URL:" +url);
        ResponseEntity<SiteManager> response = restTemplate.getForEntity(url, SiteManager.class);
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        SiteManager updated= new SiteManager.SiteManagerBuilder().copy(manager).setUserPosition("Fired").build();
        String url=baseURL + "/update";
        System.out.println("URL:" + url );
        System.out.println("Post data:" + updated);
        ResponseEntity<SiteManager> response = restTemplate.postForEntity(url,updated, SiteManager.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url=baseURL + "/delete/" + manager.getUserId();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}