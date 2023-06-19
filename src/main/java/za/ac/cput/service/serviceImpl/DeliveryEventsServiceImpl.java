package za.ac.cput.service.serviceImpl;

/* DeliveryEventsServiceImpl.java
 Entitys for the serviceImpl
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.repository.DeliveryEventsRepository;
import za.ac.cput.repository.repositoryImpl.DeliveryEventsRepositoryImpl;
import za.ac.cput.service.DeliveryEventsService;

import java.util.Set;
@Service
public class DeliveryEventsServiceImpl implements DeliveryEventsService {

    private static DeliveryEventsService service = null;
    private DeliveryEventsRepository repository = null;

    private DeliveryEventsServiceImpl() {
        repository = DeliveryEventsRepositoryImpl.getRepository();
    }

    public static DeliveryEventsService getService() {
        if (service == null) {
            service = new DeliveryEventsServiceImpl();
        }
        return service;
    }

    @Override
    public DeliveryEvents create(DeliveryEvents deliveryEvent) {
        DeliveryEvents created = repository.create(deliveryEvent);
        return created;

    }

    @Override
    public DeliveryEvents read(String deliveryEventId) {
        DeliveryEvents readDeliveryEvents = repository.read(deliveryEventId);
        return readDeliveryEvents;
    }

    @Override
    public DeliveryEvents update(DeliveryEvents deliveryEvent) {
        DeliveryEvents updateDeliveryEvents = repository.update(deliveryEvent);
        return updateDeliveryEvents;
    }

    @Override
    public boolean delete(String deliveryEventId){
        boolean success =repository.delete(deliveryEventId);
        return success;
    }

    @Override
    public Set<DeliveryEvents> getAll() {

        return repository.getAll();
    }
}
