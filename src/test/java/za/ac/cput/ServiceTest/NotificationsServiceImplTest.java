package za.ac.cput.ServiceTest;

/* NotificationsServiceImplTest.java
 Entity for the serviceImplTest
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Notifications;
import za.ac.cput.factory.NotificationsFactory;
import za.ac.cput.service.NotificationsService;
import za.ac.cput.service.serviceImpl.NotificationsServiceImpl;
import za.ac.cput.util.Helper;

;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class NotificationsServiceImplTest {

    private static NotificationsService service=null;

    public static Notifications notifications= NotificationsFactory.createNotification(Helper.generateID(), "The vehicle is on route",
            "ON ROUTE");
    public NotificationsServiceImplTest(){

        service= NotificationsServiceImpl.getService();
    }

    @Test
    void a_create() {
        Notifications created=service.create(notifications);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        Notifications read = service.read(notifications.getNotificationId());
        System.out.println("Read: "+read);
        assertNotNull(read);

    }

    @Test
    void c_update() {
        Notifications updated = new Notifications.Builder().copy(notifications).setNotificationMessage("Vehicle not on route!")
                .setNotificationStatus("Vehicle stopped!")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
