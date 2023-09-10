package za.ac.cput.repository;

/* DeliveryVehcileRepository.java
 Entity for the repository
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.DeliveryVehicle;
import java.util.List;

@Repository
public interface DeliveryVehicleRepository extends JpaRepository<DeliveryVehicle,String> {
}
