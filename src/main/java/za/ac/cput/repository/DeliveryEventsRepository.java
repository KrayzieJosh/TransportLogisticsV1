package za.ac.cput.repository;

/* DeliveryEventsRepository.java
 Entity for the repository
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import za.ac.cput.domain.DeliveryEvents;

import java.util.Set;

public interface DeliveryEventsRepository extends IRepository<DeliveryEvents, String>{

    public Set<DeliveryEvents> getAll();
}