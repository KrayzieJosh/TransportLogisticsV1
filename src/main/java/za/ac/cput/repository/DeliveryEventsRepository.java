package za.ac.cput.repository;

/* DeliveryEventsRepository.java
 Entity for the repository
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.DeliveryEvents;

import java.util.Set;
@Repository
public interface DeliveryEventsRepository extends JpaRepository<DeliveryEvents, String> {

}