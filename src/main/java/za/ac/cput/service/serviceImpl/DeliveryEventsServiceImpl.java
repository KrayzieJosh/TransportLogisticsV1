package za.ac.cput.service.serviceImpl;

/* DeliveryEventsServiceImpl.java
 Entitys for the serviceImpl
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.repository.DeliveryEventsRepository;
import za.ac.cput.service.DeliveryEventsService;

import java.util.List;


@Service
public class DeliveryEventsServiceImpl implements DeliveryEventsService {

    private DeliveryEventsRepository repository;
    @Autowired
    private DeliveryEventsServiceImpl(DeliveryEventsRepository repository) {
        this.repository = repository;
    }


    @Override
    public DeliveryEvents create(DeliveryEvents deliveryEvent) {
        return this.repository.save(deliveryEvent);
    }

    @Override
    public DeliveryEvents read(String deliveryEventId) {
        return this.repository.findById(deliveryEventId).orElse(null);
    }

    @Override
    public DeliveryEvents update(DeliveryEvents deliveryEvent) {
        if (this.repository.existsById(deliveryEvent.getDeliveryEventId()))
            return this.repository.save(deliveryEvent);
        return null;
    }

    @Override
    public boolean delete(String deliveryEventId) {
        if (this.repository.existsById(deliveryEventId)){
            this.repository.deleteById(deliveryEventId);
            return true;
        }
        return false;
    }

    @Override
    public List<DeliveryEvents> getAll() {
        return this.repository.findAll();
    }
}