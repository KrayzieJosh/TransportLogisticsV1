package za.ac.cput.repository;

/* DeliveryVehcileRepository.java
 Entity for the repository
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import za.ac.cput.domain.DeliveryVehicle;
import java.util.Set;
public interface DeliveryVehicleRepository extends IRepository<DeliveryVehicle,String> {
    public Set<DeliveryVehicle> getAll();
}
