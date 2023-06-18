package za.ac.cput.domain;

/* Driver.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.List;

@EntityScan
public class Driver implements Serializable {

    private String userId;
    private String userPosition;
    private List<Project> userProjects;
    private String vehicleId;

    public Driver() {
    }

    public Driver(String userId, String userPosition, List<Project> userProjects, String vehicleId) {
        this.userId = userId;
        this.userPosition = userPosition;
        this.userProjects = userProjects;
        this.vehicleId = vehicleId;
    }

    //builder constructor:
    private Driver(Builder builder){

        this.userId = builder.userId;
        this.userPosition = builder.userPosition;
        this.userProjects = builder.userProjects;
        this.vehicleId = builder.vehicleId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public List<Project> getUserProjects() {
        return userProjects;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "userId='" + userId + '\'' +
                ", userPosition='" + userPosition + '\'' +
                ", userProjects=" + userProjects +
                ", vehicleId='" + vehicleId + '\'' +
                '}';
    }

    public static class Builder{

        //attributes:
        private String userId;
        private String userPosition;
        private List<Project> userProjects;
        private String vehicleId;

        //setters:
        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUserPosition(String userPosition) {
            this.userPosition = userPosition;
            return this;
        }

        public Builder setUserProjects(List<Project> userProjects) {
            this.userProjects = userProjects;
            return this;
        }

        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        //copy:
        public Builder copy(Driver driver){

            this.userId = driver.userId;
            this.userPosition = driver.userPosition;
            this.userProjects = driver.userProjects;
            this.vehicleId = driver.vehicleId;
            return this;
        }

        //build:
        public Driver build(){
            return new Driver(this);
        }

    }

}

