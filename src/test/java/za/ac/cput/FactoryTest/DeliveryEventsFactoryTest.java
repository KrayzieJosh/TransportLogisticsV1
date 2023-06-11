package za.ac.cput.FactoryTest;

/* DeliveryEventsFactoryTest.java
 Entity for the test
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.factory.DeliveryEventsFactory;
import za.ac.cput.util.Helper;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryEventsFactoryTest {
    @Test

    public void test(){

        ArrayList<String> notification = new ArrayList<>();
        notification.add("On route");
        notification.add("Vehicle stopped");
        notification.add("Reached destination");



        DeliveryEvents deliveryEvent =  DeliveryEventsFactory.createDeliveryEvents
                (Helper.generateID(),"John Wattkins","17-06-2023"
                        ,"56 Epping Industria",notification);

        assertNotNull(deliveryEvent);

        System.out.println(deliveryEvent.toString());

    }
}

