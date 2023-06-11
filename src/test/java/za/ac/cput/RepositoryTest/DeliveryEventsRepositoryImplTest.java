package za.ac.cput.RepositoryTest;

/* DeliveryEventsRepositoryImplTest.java
 Entity for the implTest
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.factory.DeliveryEventsFactory;
import za.ac.cput.repository.repositoryImpl.DeliveryEventsRepositoryImpl;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryEventsRepositoryImplTest {

    private static DeliveryEventsRepositoryImpl repository = DeliveryEventsRepositoryImpl.getRepository();
    private static DeliveryEvents deliveryEvents = DeliveryEventsFactory.createDeliveryEvents(Helper.generateID(), "John Wattkins", "17-06-2023"
            , "56 Epping Industria",
            new ArrayList<>(Arrays.asList("ON ROUTE ", "Vehicle stopped!", "Reached destination"))
    );

    @Test
    void a_create() {
        DeliveryEvents created = repository.create(deliveryEvents);
        assertEquals(deliveryEvents.getDeliveryEventId(), created.getDeliveryEventId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        DeliveryEvents read = repository.read(deliveryEvents.getDeliveryEventId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        DeliveryEvents updated = new DeliveryEvents.Builder().copy(deliveryEvents).setDeliveryEventLocation("Montague Gardens")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(deliveryEvents.getDeliveryEventId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}

