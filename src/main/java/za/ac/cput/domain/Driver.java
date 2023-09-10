package za.ac.cput.domain;

/* Driver.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Driver implements Serializable {

    @Id
    private String driverId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String driverPosition;
    private String vehicleId;

    public Driver() {
    }

    //builder constructor:
    private Driver(Builder builder){

        this.driverId = builder.driverId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
        this.email = builder.email;
        this.driverPosition = builder.driverPosition;
        this.vehicleId = builder.vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getDriverPosition() {
        return driverPosition;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public static class Builder{

        //attributes:
        private String driverId;
        private String firstName;
        private String lastName;
        private String contact;
        private String email;
        private String driverPosition;
        private String vehicleId;

        //setters:
        public Builder setDriverId(String driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDriverPosition(String driverPosition) {
            this.driverPosition = driverPosition;
            return this;
        }

        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        //copy:
        public Builder copy(Driver driver){

            this.driverId = driver.driverId;
            this.firstName = driver.firstName;
            this.lastName = driver.lastName;
            this.contact = driver.contact;
            this.email = driver.email;
            this.driverPosition = driver.driverPosition;
            this.vehicleId = driver.vehicleId;
            return this;
        }

        //build:
        public Driver build(){
            return new Driver(this);
        }

    }

}

