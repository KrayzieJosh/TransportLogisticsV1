package za.ac.cput.factory;

/* DeliveryVehicleFactory.java
 Entity for the factory
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/
import za.ac.cput.util.Helper;
import za.ac.cput.domain.DeliveryVehicle;

public class DeliveryVehicleFactory {
    public static DeliveryVehicle createDeliveryVehicle(String vehicleId, String vehicleName,String vehicleLicenceExpiry, double vehicleLoadCapacity, boolean isAvailable) {
        vehicleId = Helper.generateID();
        vehicleLoadCapacity = Double.parseDouble(String.valueOf(vehicleLoadCapacity));
        isAvailable = Boolean.parseBoolean(String.valueOf(isAvailable));

        if (Helper.isNullOrEmpty(vehicleId) || Helper.isNullOrEmpty(vehicleName) || Helper.isNullOrEmpty(vehicleLicenceExpiry)|| Helper.isNullOrEmpty(String.valueOf(vehicleLoadCapacity))
                || Helper.isNullOrEmpty(String.valueOf(isAvailable))) {
            return null;
        }
        return new DeliveryVehicle.Builder()
                .setVehicleId(vehicleId)
                .setVehicleName(vehicleName)
                .setVehicleLicenceExpiry(vehicleLicenceExpiry)
                .setVehicleLoadCapacity(vehicleLoadCapacity)
                .setAvailable(isAvailable)
                .build();

    }
}

