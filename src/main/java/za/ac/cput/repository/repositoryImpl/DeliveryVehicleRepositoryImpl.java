package za.ac.cput.repository.repositoryImpl;

/* DeliveryVehicleRepositoryImpl.java
 Entity for the repositoryImpl
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/
import java.util.HashSet;
import java.util.Set;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.repository.DeliveryVehicleRepository;

public class DeliveryVehicleRepositoryImpl implements DeliveryVehicleRepository {
    private static DeliveryVehicleRepositoryImpl repository = null;
    private Set<DeliveryVehicle> deliveryVehicleDB = null;
    private DeliveryVehicleRepositoryImpl(){
        deliveryVehicleDB = new HashSet<>();
    }
    public static DeliveryVehicleRepositoryImpl getRepository(){
        if(repository == null){
            repository = new DeliveryVehicleRepositoryImpl();
        }
        return repository;
    }
   @Override
    public DeliveryVehicle create(DeliveryVehicle deliveryVehicle){
        boolean success = deliveryVehicleDB.add(deliveryVehicle);
        if(!success)
            return null;
        return deliveryVehicle;
   }
   @Override
    public DeliveryVehicle read(String vehicleId){
        for(DeliveryVehicle c : deliveryVehicleDB){
            if(c.getVehicleId().equals(vehicleId))
                return c;
        }
        return null;
   }
   @Override
    public DeliveryVehicle update(DeliveryVehicle deliveryVehicle){
        DeliveryVehicle oldVehicle = read(deliveryVehicle.getVehicleId());
        if(oldVehicle!= null){
            deliveryVehicleDB.remove(oldVehicle);
            deliveryVehicleDB.add(deliveryVehicle);
            return deliveryVehicle;
        }
        return null;
   }
   @Override
    public boolean delete(String vehicleId){
        DeliveryVehicle vehicleToDelete = read(vehicleId);
        if(vehicleToDelete == null){
            return false;
        }
        deliveryVehicleDB.remove(vehicleToDelete);
        return true;
   }
   @Override
    public Set<DeliveryVehicle>getAll(){
        return deliveryVehicleDB;
   }
}
