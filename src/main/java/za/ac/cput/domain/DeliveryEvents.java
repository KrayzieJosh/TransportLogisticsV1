package za.ac.cput.domain;

/* DeliveryEvent.java
 Entity for the domain
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import java.util.ArrayList;

public class DeliveryEvents {
    private String deliveryEventId;
    private String deliveryName;
    private String deliveryDate;
    private String deliveryEventLocation;
    private ArrayList<String> notification;

    public DeliveryEvents() {
    }

    private DeliveryEvents (Builder builder){

        this.deliveryEventId = builder.deliveryEventId;
        this.deliveryName = builder.deliveryName;
        this.deliveryDate = builder.deliveryDate;
        this.deliveryEventLocation = builder.deliveryEventLocation;
        this.notification = builder.notification;
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

    public ArrayList<String> getNotification() {
        return notification;
    }

    @Override
    public String toString() {
        return "DeliveryEvents{" +
                "deliveryEventId='" + deliveryEventId + '\'' +
                ", deliveryName='" + deliveryName + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", deliveryEventLocation='" + deliveryEventLocation + '\'' +
                ", notification=" + notification +
                '}';
    }

    public static class Builder {

        private String deliveryEventId;
        private String deliveryName;
        private String deliveryDate;
        private String deliveryEventLocation;
        private ArrayList<String> notification;


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

        public Builder setNotification(ArrayList<String> notification) {
            this.notification = notification;
            return this;

        }
        public Builder copy(DeliveryEvents deliveryEvent){

            this.deliveryEventId = deliveryEvent.deliveryEventId;
            this.deliveryName = deliveryEvent.deliveryName;
            this.deliveryDate = deliveryEvent.deliveryDate;
            this.deliveryEventLocation = deliveryEvent.deliveryEventLocation;
            this.notification = deliveryEvent.notification;
            return this;
        }
        public DeliveryEvents build(){
            return new DeliveryEvents(this);

        }
    }
}



