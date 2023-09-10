package za.ac.cput.FactoryTest;

/* DeliveryHistoryFactoryTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.factory.DeliveryHistoryFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

public class DeliveryHistoryFactoryTest extends TestCase {

    @Test
    public void testCreateNewDeliveryHistory(){

        DeliveryHistory deliveryHistory = DeliveryHistoryFactory.createNewDeliveryHistory(Helper.generateID(), Helper.generateID());
        assertNotNull(deliveryHistory);
        System.out.println(deliveryHistory.toString());
    }
}
