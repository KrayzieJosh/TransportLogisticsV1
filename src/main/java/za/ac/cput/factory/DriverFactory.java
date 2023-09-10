package za.ac.cput.factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

public class DriverFactory {

    public static Driver createNewDriver(String firstName, String lastName, String contact, String email, String driverPosition, String vehicleId){

            if(Helper.isStringNullOrEmpty(firstName) || Helper.isStringNullOrEmpty(lastName)){
                return null;
            }

            if(Helper.isStringNullOrEmpty(contact) || Helper.isStringNullOrEmpty(driverPosition)){
                return null;
            }

            if (!Helper.isValidEmail(email)){
                return null;
            }

            if (Helper.isStringNullOrEmpty(vehicleId)){
                return null;
            }

            String driverId = Helper.generateID();

            return new Driver.Builder()
                    .setDriverId(driverId)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setContact(contact)
                    .setEmail(email)
                    .setDriverPosition(driverPosition)
                    .setVehicleId(vehicleId)
                    .build();
        }

}
