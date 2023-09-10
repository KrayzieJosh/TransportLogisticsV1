package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DriverServiceImplTest {

    @Autowired
    private DriverServiceImpl service;

    static Driver driver =
            DriverFactory.createNewDriver("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver", Helper.generateID());


    @Test
    void a_create() {
        Driver created = service.create(driver);
        assertEquals(driver.getDriverId(), created.getDriverId());
        System.out.println("Created: "+created);
    }

    @Test
    void b_read() {
        Driver read = service.read(driver.getDriverId());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update() {
        Driver updated = new Driver.Builder()
                .copy(driver)
                .setFirstName("Garry")
                .setLastName("Blackbeard")
                .setDriverPosition("Resource driver")
                .build();
        assertNotNull(updated);
        System.out.println("Update: "+updated);
    }

    @Test
    @Disabled
    void e_delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Get all:");
        System.out.println(service.getAll());
    }
}