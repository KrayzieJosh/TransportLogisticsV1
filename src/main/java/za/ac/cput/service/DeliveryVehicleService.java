package za.ac.cput.service;

/* DeliveryVehicleService.java
 Entity for the service
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import za.ac.cput.domain.DeliveryVehicle;
import java.util.Set;
public interface DeliveryVehicleService {
    DeliveryVehicle create(DeliveryVehicle deliveryVehicle);
    DeliveryVehicle read(String vehicleId);
    DeliveryVehicle update(DeliveryVehicle deliveryVehicle);
    boolean delete (String vehicleId);
    public Set<DeliveryVehicle>getAll();
}
