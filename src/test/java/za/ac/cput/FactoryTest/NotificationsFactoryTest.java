package za.ac.cput.FactoryTest;

/* NotificationsFactoryTest.java
 Entity for the test
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Notifications;
import za.ac.cput.factory.NotificationsFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class NotificationsFactoryTest {
    @Test

    public void test(){

        Notifications notification = NotificationsFactory.createNotification(Helper.generateID(),"The vehicle is on route",
                "ON ROUTE");
        assertNotNull(notification);
        System.out.println(notification.toString());

    }
}