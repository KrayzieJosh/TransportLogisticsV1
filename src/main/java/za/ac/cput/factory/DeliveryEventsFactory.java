package za.ac.cput.factory;

/* DeliveryEventFactory.java
 Entity for the factory
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/

import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.util.Helper;
import java.util.ArrayList;

public class DeliveryEventsFactory {
    public static DeliveryEvents createDeliveryEvents(String deliveryEventId, String deliveryName, String deliveryDate, String deliveryEventLocation, ArrayList<String> notification){

        deliveryEventId= Helper.generateID();


        if (Helper.isNullOrEmpty(deliveryEventId)||Helper.isNullOrEmpty(deliveryName)||Helper.isNullOrEmpty(deliveryDate)||Helper.isNullOrEmpty(deliveryEventLocation)||Helper.isListEmpty(notification)){
            return null;
        }
        return new DeliveryEvents.Builder()
                .setDeliveryEventId(deliveryEventId)
                .setDeliveryName(deliveryName)
                .setDeliveryDate(deliveryDate)
                .setDeliveryEventLocation(deliveryEventLocation)
                .setNotification(notification)
                .build();
    }
}

