package za.ac.cput.ServiceTest;

/* DeliveryEventsServiceImplTest.java
 Entity for the serviceImplTest
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.factory.DeliveryEventsFactory;
import za.ac.cput.service.DeliveryEventsService;
import za.ac.cput.service.serviceImpl.DeliveryEventsServiceImpl;
import za.ac.cput.util.Helper;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryEventsServiceImplTest {

    private static DeliveryEventsService service=null;

    public static DeliveryEvents deliveryEvents= DeliveryEventsFactory.createDeliveryEvents(Helper.generateID(), "John Wattkins", "17-06-2023"
            , "56 Epping Industria",
            new ArrayList<>(Arrays.asList("ON ROUTE ", "Vehicle stopped!", "Reached destination")));
    public DeliveryEventsServiceImplTest(){

        service= DeliveryEventsServiceImpl.getService();
    }

    @Test
    void a_create() {
        DeliveryEvents created=service.create(deliveryEvents);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        DeliveryEvents read = service.read(deliveryEvents.getDeliveryEventId());
        System.out.println("Read: "+read);
        assertNotNull(read);

    }

    @Test
    void c_update() {
        DeliveryEvents updated = new DeliveryEvents.Builder().copy(deliveryEvents).setDeliveryEventLocation("Montague Gardens")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete(){
        String id=deliveryEvents.getDeliveryEventId();
        boolean success=service.delete(id);
        assertTrue(success);
        System.out.println("Success: "+ success);
    }
    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
