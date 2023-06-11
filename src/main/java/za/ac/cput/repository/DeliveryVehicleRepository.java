package za.ac.cput.repository;
import za.ac.cput.domain.DeliveryVehicle;
import java.util.Set;
public interface DeliveryVehicleRepository extends IRepository<DeliveryVehicle,String> {
    public Set<DeliveryVehicle> getAll();
}
