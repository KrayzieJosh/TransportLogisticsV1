package za.ac.cput.domain;

/* DeliveryEvent.java
 Entity for the domain
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DeliveryEvents {
    @Id
    private String deliveryEventId;
    private String deliveryName;
    private String deliveryDate;
    private String deliveryEventLocation;


    private DeliveryEvents (Builder builder){

        this.deliveryEventId = builder.deliveryEventId;
        this.deliveryName = builder.deliveryName;
        this.deliveryDate = builder.deliveryDate;
        this.deliveryEventLocation = builder.deliveryEventLocation;
    }

    protected DeliveryEvents() {

    }

    public String getDeliveryEventId() {
        return deliveryEventId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryEventLocation() {
        return deliveryEventLocation;
    }




    @Override
    public String toString() {
        return "DeliveryEvents{" +
                "deliveryEventId='" + deliveryEventId + '\'' +
                ", deliveryName='" + deliveryName + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", deliveryEventLocation='" + deliveryEventLocation + '\'' +

                '}';
    }

    public static class Builder {

        private String deliveryEventId;
        private String deliveryName;
        private String deliveryDate;
        private String deliveryEventLocation;



        public Builder setDeliveryEventId(String deliveryEventId) {
            this.deliveryEventId = deliveryEventId;
            return this;
        }

        public Builder setDeliveryName(String deliveryName) {
            this.deliveryName = deliveryName;
            return this;

        }

        public Builder setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;

        }

        public Builder setDeliveryEventLocation(String deliveryEventLocation) {
            this.deliveryEventLocation = deliveryEventLocation;
            return this;
        }




        public Builder copy(DeliveryEvents deliveryEvent){

            this.deliveryEventId = deliveryEvent.deliveryEventId;
            this.deliveryName = deliveryEvent.deliveryName;
            this.deliveryDate = deliveryEvent.deliveryDate;
            this.deliveryEventLocation = deliveryEvent.deliveryEventLocation;
            return this;
        }
        public DeliveryEvents build(){
            return new DeliveryEvents(this);

        }
    }
}
