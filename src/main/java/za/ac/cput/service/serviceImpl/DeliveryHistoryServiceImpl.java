package za.ac.cput.service.serviceImpl;

/* DeliveryHistoryServiceImpl.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/


import org.springframework.stereotype.Service;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.repository.DeliveryHistoryRepository;
import za.ac.cput.repository.repositoryImpl.DeliveryHistoryRepositoryImpl;
import za.ac.cput.service.DeliveryHistoryService;

import java.util.Set;

@Service
public class DeliveryHistoryServiceImpl implements DeliveryHistoryService {

    private static DeliveryHistoryService service = null;
    private DeliveryHistoryRepository repository = null;
    private DeliveryHistoryServiceImpl() {repository = DeliveryHistoryRepositoryImpl.getRepository();}

    public static DeliveryHistoryService getService(){
        if(service == null){
            service = new DeliveryHistoryServiceImpl();
        }
        return service;
    }

    @Override
    public DeliveryHistory create(DeliveryHistory deliveryHistory) {
        DeliveryHistory created = repository.create(deliveryHistory);
        return created;
    }

    @Override
    public DeliveryHistory read(String deliveryOrderId) {
        DeliveryHistory readDeliveryHistory = repository.read(deliveryOrderId);
        return readDeliveryHistory;
    }

    @Override
    public DeliveryHistory update(DeliveryHistory deliveryHistory) {
        DeliveryHistory updateDeliveryHistory = repository.update(deliveryHistory);
        return updateDeliveryHistory;
    }

    @Override
    public Set<DeliveryHistory> getAll() {
        return repository.getAll();
    }

}
