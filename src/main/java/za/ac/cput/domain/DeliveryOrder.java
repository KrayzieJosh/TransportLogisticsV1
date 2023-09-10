package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DeliveryOrder", schema = "")
public class DeliveryOrder {

    @Id
    private String deliveryOrderId;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    @Column(name = "deliveryDate")
    private String deliveryDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MaterialQuote> materialQuotes;

    public DeliveryOrder() {
    }

    protected DeliveryOrder(DeliveryOrderBuilder builder) {
        this.deliveryOrderId = builder.deliveryOrderId;
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryDate = builder.deliveryDate;
        this.materialQuotes = builder.materialQuotes;
    }

    public DeliveryOrder(String deliveryOrderId, String deliveryAddress, String deliveryDate, List<MaterialQuote> materialQuotes) {
        this.deliveryOrderId=deliveryOrderId;
        this.deliveryAddress=deliveryAddress;
        this.deliveryDate=deliveryDate;
        this.materialQuotes=materialQuotes;
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



    public static class DeliveryOrderBuilder {

        private String deliveryOrderId;
        private String deliveryAddress;
        private String deliveryDate;
        private List<MaterialQuote> materialQuotes;

        public DeliveryOrderBuilder setDeliveryOrderId(String deliveryOrderId) {
            this.deliveryOrderId = deliveryOrderId;
            return this;
        }

        public DeliveryOrderBuilder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public DeliveryOrderBuilder setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public DeliveryOrderBuilder setMaterialQuotes(List<MaterialQuote> materialQuotes) {
            this.materialQuotes = materialQuotes;
            return this;
        }

        @Override
        public String toString() {
            return "DeliveryOrderBuilder{" +
                    "deliveryOrderId='" + deliveryOrderId + '\'' +
                    ", deliveryAddress='" + deliveryAddress + '\'' +
                    ", deliveryDate='" + deliveryDate + '\'' +
                    ", materialQuotes=" + materialQuotes +
                    '}';
        }

        public DeliveryOrderBuilder copy(DeliveryOrder deliveryOrder) {
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