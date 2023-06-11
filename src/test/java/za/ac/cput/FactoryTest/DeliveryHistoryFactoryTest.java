package za.ac.cput.FactoryTest;

/* DeliveryHistoryFactoryTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.domain.User;
import za.ac.cput.factory.DeliveryHistoryFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

public class DeliveryHistoryFactoryTest extends TestCase {

    //UserId
    User user1 = UserFactory.createUser(Helper.generateID(), "Lyle","Andre", "Esau", "0610560987","lyle@gmail.com", "Code B");
    User user2 = UserFactory.createUser(Helper.generateID(), "Jack","Wayne", "Adams", "0610956987","Jack@gmail.com", "Code B");

    ArrayList<User> listOfUsers = new ArrayList<User>(Arrays.asList( user1, user2));
    @Test
    public void testCreateNewDeliveryHistory(){

        DeliveryHistory deliveryHistory = DeliveryHistoryFactory.createNewDeliveryHistory(Helper.generateID(), listOfUsers, Helper.generateID());
        assertNotNull(deliveryHistory);
        deliveryHistory.toString();
    }
}
