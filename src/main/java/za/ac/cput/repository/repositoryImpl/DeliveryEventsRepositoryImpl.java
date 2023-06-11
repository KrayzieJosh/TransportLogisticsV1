package za.ac.cput.repository.repositoryImpl;

/* DeliveryEventRepositoryImpl.java
 Entity for the impl
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.repository.DeliveryEventsRepository;
import java.util.HashSet;
import java.util.Set;

public class DeliveryEventsRepositoryImpl implements DeliveryEventsRepository {

    private static DeliveryEventsRepositoryImpl repository=null;
    private Set<DeliveryEvents> deliveryEventDB=null;

    private DeliveryEventsRepositoryImpl(){
        deliveryEventDB=new HashSet<>();
    }

    public static DeliveryEventsRepositoryImpl getRepository() {
        if (repository==null){
            repository=new DeliveryEventsRepositoryImpl();
        }
        return repository;
    }
    @Override
    public DeliveryEvents create (DeliveryEvents deliveryEvent){
        boolean success= deliveryEventDB.add(deliveryEvent);
        if (!success){
            return null;
        }
        return deliveryEvent;
    }
    @Override
    public DeliveryEvents read(String deliveryEventId) {
        for (DeliveryEvents d : deliveryEventDB) {
            if (d.getDeliveryEventId().equals(deliveryEventId))
                return d;
        }
        return null;
    }

    @Override
    public DeliveryEvents update(DeliveryEvents deliveryEvents) {
        DeliveryEvents oldDeliveryEvents = read(deliveryEvents.getDeliveryEventId());
        if (oldDeliveryEvents != null) {
            deliveryEventDB.remove(oldDeliveryEvents);
            deliveryEventDB.add(deliveryEvents);
            return deliveryEvents;
        }
        return null;
    }

    @Override
    public boolean delete(String deliveryEventId) {
        DeliveryEvents deliveryEventToDelete = read(deliveryEventId);
        if (deliveryEventToDelete == null) {
            return false;
        }
        deliveryEventDB.remove(deliveryEventToDelete);
        return true;
    }

    @Override
    public Set<DeliveryEvents> getAll () {

        return deliveryEventDB;
    }
}






