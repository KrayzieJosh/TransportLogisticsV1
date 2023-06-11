package za.ac.cput.RepositoryTest;

/* NotificationsRepositoryImplTest.java
 Entity for the implTest
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Notifications;
import za.ac.cput.factory.NotificationsFactory;
import za.ac.cput.repository.repositoryImpl.NotificationsRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class NotificationsRepositoryImplTest {

    private static NotificationsRepositoryImpl repository = NotificationsRepositoryImpl.getRepository();
    private static Notifications notifications = NotificationsFactory.createNotification(Helper.generateID(), "The vehicle is on route",
            "ON ROUTE");

    @Test
    void a_create() {
        Notifications created = repository.create(notifications);
        assertEquals(notifications.getNotificationId(), created.getNotificationId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Notifications read = repository.read(notifications.getNotificationId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Notifications updated = new Notifications.Builder().copy(notifications).setNotificationMessage("Vehicle not on route!")
                .setNotificationStatus("Vehicle stopped!")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(notifications.getNotificationId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }

}