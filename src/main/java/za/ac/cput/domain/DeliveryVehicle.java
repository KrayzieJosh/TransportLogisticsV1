package za.ac.cput.domain;

/* DeliveryVehicle.java
 Entity for the domain
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/
public class DeliveryVehicle {
    private String vehicleId;
    private String vehicleName;
    private String vehicleLicence;
    private Double vehicleLoadCapacity;
    private Boolean isAvailable;


    private DeliveryVehicle(Builder builder){
        this.vehicleId = builder.vehicleId;
        this.vehicleName = builder.vehicleName;
        this.vehicleLicence = builder.vehicleLicence;
        this.vehicleLoadCapacity = builder.vehicleLoadCapacity;
        this.isAvailable = builder.isAvailable;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }
    public String getVehicleLicence(){return vehicleLicence;}

    public Double getVehicleLoadCapacity() {
        return vehicleLoadCapacity;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "DeliveryVehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleLicence=" + vehicleLicence +'\''+
                ", vehicleLoadCapacity=" + vehicleLoadCapacity +
                ", isAvailable=" + isAvailable +
                '}';
    }
    public static class Builder{
        private String vehicleId;
        private String vehicleName;
        private String vehicleLicence;
        private Double vehicleLoadCapacity;
        private Boolean isAvailable;

        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setVehicleName(String vehicleName) {
            this.vehicleName = vehicleName;
            return this;
        }
        public Builder setVehicleLicence(String vehicleLicence) {
            this.vehicleLicence = vehicleLicence;
            return this;
        }

        public Builder setVehicleLoadCapacity(Double vehicleLoadCapacity) {
            this.vehicleLoadCapacity = vehicleLoadCapacity;
            return this;
        }

        public Builder setAvailable(Boolean available) {
            isAvailable = available;
            return this;
        }
        public Builder copy(DeliveryVehicle deliveryVehicle){
            this.vehicleId = deliveryVehicle.vehicleId;
            this.vehicleName = deliveryVehicle.vehicleName;
            this.vehicleLicence = deliveryVehicle.vehicleLicence;
            this.vehicleLoadCapacity = deliveryVehicle.vehicleLoadCapacity;
            this.isAvailable = deliveryVehicle.isAvailable;
            return this;
        }
        public DeliveryVehicle build(){
            return new DeliveryVehicle(this);
        }
    }

}
