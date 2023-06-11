package za.ac.cput.domain;

import java.util.List;

/*
   Entity for DeliveryOrder
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/

public class DeliveryOrder {
    private String deliveryOrderId;
    private String deliveryAddress;
    private String deliveryDate;
    private List<MaterialQuote> materialQuotes;

    public DeliveryOrder(Builder builder) {
        this.deliveryOrderId = builder.deliveryOrderId;
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryDate = builder.deliveryDate;
        this.materialQuotes = builder.materialQuotes;
    }

    public String getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public List<MaterialQuote> getMaterialQuotes() {
        return materialQuotes;
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "deliveryOrderId='" + deliveryOrderId + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", materialQuotes=" + materialQuotes +
                '}';
    }



    public static class Builder {
        private String deliveryOrderId;
        private String deliveryAddress;
        private String deliveryDate;
        private List<MaterialQuote> materialQuotes;

        public Builder setDeliveryOrderId(String deliveryOrderId) {
            this.deliveryOrderId = deliveryOrderId;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder setMaterialQuotes(List<MaterialQuote> materialQuotes) {
            this.materialQuotes = materialQuotes;
            return this;
        }

        public Builder copy(DeliveryOrder deliveryOrder) {
            this.deliveryOrderId = deliveryOrder.deliveryOrderId;
            this.deliveryAddress = deliveryOrder.deliveryAddress;
            this.deliveryDate = deliveryOrder.deliveryDate;
            this.materialQuotes = deliveryOrder.materialQuotes;
            return this;
        }

        public DeliveryOrder build() {
            return new DeliveryOrder(this);
        }
    }
}
