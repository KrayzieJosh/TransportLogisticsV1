package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.factory.DeliveryVehicleFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryVehicleFactoryTest {

    @Test
    public void createDeliveryVehicle() {
        DeliveryVehicle deliveryVehicle = DeliveryVehicleFactory.createDeliveryVehicle(
                Helper.generateID(),"Izuzu Delivery vehicle",25000.00
                        ,true);

        assertNotNull(deliveryVehicle);
        System.out.println(deliveryVehicle.toString());

    }
}