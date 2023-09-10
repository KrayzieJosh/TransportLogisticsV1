package za.ac.cput.RepositoryTest;

/* DeliveryHistoryRepositoryImplTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.domain.User;
import za.ac.cput.factory.DeliveryHistoryFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DeliveryHistoryRepositoryImplTest {

    //User Arraylist:
    static User user1 = UserFactory.createUser(Helper.generateID(), "Lyle","Andre", "Esau", "0610560987","lyle@gmail.com", "Code B");
    static User user2 = UserFactory.createUser(Helper.generateID(), "Jack","Wayne", "Adams", "0610956987","Jack@gmail.com", "Code B");
    static ArrayList<User> listOfUsers = new ArrayList<User>(Arrays.asList( user1, user2));

    private static DeliveryHistoryRepositoryImpl repository = DeliveryHistoryRepositoryImpl.getRepository();
    private static DeliveryHistory deliveryHistory = DeliveryHistoryFactory.createNewDeliveryHistory(Helper.generateID(), listOfUsers, Helper.generateID());

    @Test
    void a_create() {
        DeliveryHistory created = repository.create(deliveryHistory);
        assertEquals(deliveryHistory.getDeliveryOrderId(), created.getDeliveryOrderId());
        System.out.println("Created: "+created);
    }

    @Test
    void b_read(){
        DeliveryHistory read = repository.read(deliveryHistory.getDeliveryOrderId());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update(){
        DeliveryHistory updated = new DeliveryHistory.Builder().copy(deliveryHistory).setVehicleId(Helper.generateID()).build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+updated);
    }

    @Test
    void e_delete(){
        boolean success = repository.delete(deliveryHistory.getDeliveryOrderId());
        assertTrue(success);
        System.out.println("Delete: "+success);
    }

    @Test
    void d_getAll(){
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}
