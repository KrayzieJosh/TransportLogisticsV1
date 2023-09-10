package za.ac.cput.ServiceTest;

/* DeliveryHistoryServiceImplTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.factory.DeliveryHistoryFactory;
import za.ac.cput.service.DeliveryHistoryService;
import za.ac.cput.service.serviceImpl.DeliveryHistoryServiceImpl;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryHistoryServiceImplTest {

    //UserId
    static User user1 = UserFactory.createUser(Helper.generateID(), "Lyle","Andre", "Esau", "0610560987","lyle@gmail.com", "Code B");
    static User user2 = UserFactory.createUser(Helper.generateID(), "Jack","Wayne", "Adams", "0610956987","Jack@gmail.com", "Code B");
    static ArrayList<User> listOfUsers = new ArrayList<User>(Arrays.asList( user1, user2));

    private static DeliveryHistoryService service = null;
    private static DeliveryHistory deliveryHistory = DeliveryHistoryFactory.createNewDeliveryHistory(Helper.generateID(), listOfUsers, Helper.generateID());

    public DeliveryHistoryServiceImplTest(){

        service = DeliveryHistoryServiceImpl.getService();
    }

    @Test
    void a_create() {
        DeliveryHistory created=service.create(deliveryHistory);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        DeliveryHistory read = service.read(deliveryHistory.getDeliveryOrderId());
        System.out.println("Read: "+read);
        assertNotNull(read);
    }

    @Test
    void c_update() {
        DeliveryHistory updated = new DeliveryHistory.Builder().copy(deliveryHistory).setVehicleId(Helper.generateID()).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}