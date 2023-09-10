package za.ac.cput.RepositoryTest;

/* DeliveryVehicleRepositoryImplTest.java
 Package: RepositoryTest
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.factory.DeliveryVehicleFactory;
import za.ac.cput.repository.repositoryImpl.DeliveryVehicleRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class DeliveryVehicleRepositoryImplTest {

    private static DeliveryVehicleRepositoryImpl repository = DeliveryVehicleRepositoryImpl.getRepository();
    private static DeliveryVehicle deliveryVehicle = DeliveryVehicleFactory.createDeliveryVehicle(Helper.generateID(), "Izuzu Delivery Vehicle","04/09/2023", 25000.00,
            true);
    @Test
    void a_create() {
        DeliveryVehicle created = repository.create(deliveryVehicle);
        assertEquals(deliveryVehicle.getVehicleId(), created.getVehicleId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        DeliveryVehicle read = repository.read(deliveryVehicle.getVehicleId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        DeliveryVehicle updated = new DeliveryVehicle.Builder().copy(deliveryVehicle).setVehicleLoadCapacity(20000.00)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(deliveryVehicle.getVehicleId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}
