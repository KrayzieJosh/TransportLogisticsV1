package za.ac.cput.domain;

public class DeliveryVehicle {
    private String vehicleId;
    private String vehicleName;
    private Double vehicleLoadCapacity;
    private Boolean isAvailable;

    private DeliveryVehicle(Builder builder){
        this.vehicleId = builder.vehicleId;
        this.vehicleName = builder.vehicleName;
        this.vehicleLoadCapacity = builder.vehicleLoadCapacity;
        this.isAvailable = builder.isAvailable;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

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
                ", vehicleLoadCapacity=" + vehicleLoadCapacity +
                ", isAvailable=" + isAvailable +
                '}';
    }
    public static class Builder{
        private String vehicleId;
        private String vehicleName;
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

        public Builder setVehicleLoadCapacity(Double vehicleLoadCapacity) {
            this.vehicleLoadCapacity = vehicleLoadCapacity;
            return this;
        }

        public Builder setAvailable(Boolean available) {
            isAvailable = available;
            return this;
        }
        public Builder copy(DeliveryVehicle deliveryVehicle){ //this sets the values of the builder based on existing builder object
            this.vehicleId = deliveryVehicle.vehicleId;
            this.vehicleName = deliveryVehicle.vehicleName;
            this.vehicleLoadCapacity = deliveryVehicle.vehicleLoadCapacity;
            this.isAvailable = deliveryVehicle.isAvailable;
            return this; // this returns the builder object
        }
        public DeliveryVehicle build(){
            return new DeliveryVehicle(this);
        }
    }

}
