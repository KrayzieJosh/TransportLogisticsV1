package za.ac.cput.service;

/* DeliveryEventsService.java
 Entity for the service
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DeliveryEvents;

import java.util.Set;

@Service
public interface DeliveryEventsService {
    DeliveryEvents create(DeliveryEvents deliveryEvent);

    DeliveryEvents read(String deliveryEventId);

    DeliveryEvents update (DeliveryEvents deliveryEvent);

    boolean delete(String deliveryEventId);

    public Set<DeliveryEvents> getAll();
}
