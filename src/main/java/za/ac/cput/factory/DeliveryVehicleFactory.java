package za.ac.cput.factory;
import za.ac.cput.util.Helper;
import za.ac.cput.domain.DeliveryVehicle;

public class DeliveryVehicleFactory {
    public static DeliveryVehicle createDeliveryVehicle(String vehicleId, String vehicleName,
                                                               double vehicleLoadCapacity, boolean isAvailable) {
        vehicleId = Helper.generateID();
        vehicleLoadCapacity = Double.parseDouble(String.valueOf(vehicleLoadCapacity));
        isAvailable = Boolean.parseBoolean(String.valueOf(isAvailable));

        if (Helper.isNullOrEmpty(vehicleId) || Helper.isNullOrEmpty(vehicleName) || Helper.isNullOrEmpty(String.valueOf(vehicleLoadCapacity))
                || Helper.isNullOrEmpty(String.valueOf(isAvailable))) {
            return null;
        }
        return new DeliveryVehicle.Builder()
                .setVehicleId(vehicleId)
                .setVehicleName(vehicleName)
                .setVehicleLoadCapacity(vehicleLoadCapacity)
                .setAvailable(isAvailable)
                .build();

    }
}

