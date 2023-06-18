package za.ac.cput.domain;

/* DeliveryHistory.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@EntityScan
public class DeliveryHistory {

    private String deliveryOrderId;
    private List<User> userId;
    private String vehicleId;

    public DeliveryHistory() {
    }

    // private builder constructor:
    private DeliveryHistory(Builder builder){

        this.deliveryOrderId = builder.deliveryOrderId;
        this.userId = builder.userId;
        this.vehicleId = builder.vehicleId;

    }

    public String getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public List<User> getUserId() {
        return userId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    @Override
    public String toString() {
        return "DeliveryHistory{" +
                "deliveryOrderId='" + deliveryOrderId + '\'' +
                ", userId=" + userId +
                ", vehicleId='" + vehicleId + '\'' +
                '}';
    }

    public static class Builder{

        private String deliveryOrderId;
        private List<User> userId;
        private String vehicleId;

        public Builder setDeliveryOrderId(String deliveryOrderId) {
            this.deliveryOrderId = deliveryOrderId;
            return this;
        }

        public Builder setUserId(List<User> userId) {
            this.userId = userId;
            return this;
        }

        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder copy(DeliveryHistory deliveryHistory){

            this.deliveryOrderId = deliveryHistory.deliveryOrderId;
            this.userId = deliveryHistory.userId;
            this.vehicleId = deliveryHistory.vehicleId;
            return this;

        }

        public DeliveryHistory build(){
            return new DeliveryHistory(this);
        }

    }

}
