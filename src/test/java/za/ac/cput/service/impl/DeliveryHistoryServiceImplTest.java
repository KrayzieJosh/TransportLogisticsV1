package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.factory.DeliveryHistoryFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DeliveryHistoryServiceImplTest {

    @Autowired
    private DeliveryHistoryServiceImpl service;

     private static DeliveryHistory deliveryHistory = DeliveryHistoryFactory.createNewDeliveryHistory(Helper.generateID(), Helper.generateID());

    @Test
    void a_create() {
        DeliveryHistory created = service.create(deliveryHistory);
        assertEquals(deliveryHistory.getDeliveryOrderId(), created.getDeliveryOrderId());
        System.out.println("Created: "+created);
    }

    @Test
    void b_read() {
        DeliveryHistory read = service.read(deliveryHistory.getDeliveryOrderId());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update() {
        DeliveryHistory updated = new DeliveryHistory.Builder().copy(deliveryHistory).setVehicleId("123456789").build();
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