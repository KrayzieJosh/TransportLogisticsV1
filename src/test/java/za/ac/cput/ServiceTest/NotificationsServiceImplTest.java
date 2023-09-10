package za.ac.cput.ServiceTest;

/* NotificationsServiceImplTest.java
 Entity for the serviceImplTest
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Notifications;
import za.ac.cput.factory.NotificationsFactory;
import za.ac.cput.service.NotificationsService;
import za.ac.cput.service.serviceImpl.NotificationsServiceImpl;
import za.ac.cput.util.Helper;

;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class NotificationsServiceImplTest {

    @Autowired
    private NotificationsServiceImpl service;

    public static Notifications notifications= NotificationsFactory.createNotification(Helper.generateID(), "The vehicle is on route",
            "ON ROUTE");
    @Test
    void a_create() {
        Notifications created=service.create(notifications);
        assertEquals(notifications.getNotificationId(),created.getNotificationId());
        System.out.println("Created : "+created);
    }

    @Test
    void b_read() {
        Notifications read=service.read(notifications.getNotificationId());
        assertNotNull(read);
        System.out.println("Read : "+read);

    }

    @Test
    void c_update() {
        Notifications newNotification=new Notifications.Builder().copy(notifications).setNotificationMessage("Vehicle not on route!")
                .setNotificationStatus("Vehicle stopped!")
                .build();
        Notifications updated=service.update(newNotification);
        assertEquals(newNotification.getNotificationStatus(),updated.getNotificationStatus());
        System.out.println("Updated : "+updated);

    }

    @Test
    @Disabled
    void e_delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Get All : ");
        System.out.println(service.getAll());
    }
}
