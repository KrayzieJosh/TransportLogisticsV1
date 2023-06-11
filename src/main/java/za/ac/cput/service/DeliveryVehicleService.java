package za.ac.cput.service;
import za.ac.cput.domain.DeliveryVehicle;
import java.util.Set;
public interface DeliveryVehicleService {
    DeliveryVehicle create(DeliveryVehicle deliveryVehicle);
    DeliveryVehicle read(String vehicleId);
    DeliveryVehicle update(DeliveryVehicle deliveryVehicle);
    boolean delete (String vehicleId);
    public Set<DeliveryVehicle>getAll();
}
