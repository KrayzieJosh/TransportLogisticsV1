package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.factory.DeliveryVehicleFactory;
import za.ac.cput.service.DeliveryVehicleService;
import za.ac.cput.service.serviceImpl.DeliveryVehicleServiceImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class DeliveryVehicleServiceImplTest {
    private static DeliveryVehicleService service=null;
    public static DeliveryVehicle deliveryVehicle = DeliveryVehicleFactory.createDeliveryVehicle(Helper.generateID(), "Izuzu Delivery Vehicle", 25000.00
            , true);
    public DeliveryVehicleServiceImplTest(){

        service= DeliveryVehicleServiceImpl.getService();
    }

    @Test
    void a_create() {
        DeliveryVehicle created=service.create(deliveryVehicle);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        DeliveryVehicle read = service.read(deliveryVehicle.getVehicleId());
        System.out.println("Read: "+read);
        assertNotNull(read);

    }

    @Test
    void c_update() {
        DeliveryVehicle updated = new DeliveryVehicle.Builder().copy(deliveryVehicle).setVehicleName("Mercedez Delivery Vehicle")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete(){
        String id=deliveryVehicle.getVehicleId();
        boolean success=service.delete(id);
        assertTrue(success);
        System.out.println("Success: "+ success);
    }
    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
