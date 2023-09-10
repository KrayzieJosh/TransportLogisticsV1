package za.ac.cput.domain;

/* DeliveryHistory.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DeliveryHistory {

    @Id
    private String deliveryOrderId;
    private String vehicleId;

    //constructor
    public DeliveryHistory() {
    }

    // private builder constructor:
    private DeliveryHistory(Builder builder){

        this.deliveryOrderId = builder.deliveryOrderId;
        this.vehicleId = builder.vehicleId;

    }

    public String getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    @Override
    public String toString() {
        return "DeliveryHistory{" +
                "deliveryOrderId='" + deliveryOrderId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                '}';
    }

    public static class Builder{

        private String deliveryOrderId;
        private String vehicleId;

        public Builder setDeliveryOrderId(String deliveryOrderId) {
            this.deliveryOrderId = deliveryOrderId;
            return this;
        }

        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder copy(DeliveryHistory deliveryHistory){

            this.deliveryOrderId = deliveryHistory.deliveryOrderId;
            this.vehicleId = deliveryHistory.vehicleId;
            return this;

        }

        public DeliveryHistory build(){
            return new DeliveryHistory(this);
        }

    }

}
