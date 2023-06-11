package za.ac.cput.factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Project;
import za.ac.cput.util.Helper;

/* DriverFactory.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import java.util.List;

public class DriverFactory {

    public static Driver createNewDriver(String userId, String userPosition, List<Project> userProjects, String vehicleId){

        if(Helper.isStringNullOrEmpty(userPosition) || Helper.isStringNullOrEmpty(userId)){
            return null;
        }

        if(Helper.isStringNullOrEmpty(vehicleId)){
            return null;
        }

        if(Helper.isListNullOrEmpty(userProjects)){
            return null;
        }

        return new Driver.Builder()
                .setUserId(userId)
                .setUserPosition(userPosition)
                .setUserProjects(userProjects)
                .setVehicleId(vehicleId)
                .build();
    }

}
