package za.ac.cput.service;

/* DeliveryEventsService.java
 Entity for the service
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import za.ac.cput.domain.DeliveryEvents;

import java.util.List;
import java.util.Set;

public interface DeliveryEventsService {
    DeliveryEvents create(DeliveryEvents deliveryEvent);

    DeliveryEvents read(String deliveryEventId);

    DeliveryEvents update (DeliveryEvents deliveryEvent);

    boolean delete(String deliveryEventId);

    public List<DeliveryEvents> getAll();
}
