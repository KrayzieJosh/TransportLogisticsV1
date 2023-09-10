package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.repository.DeliveryHistoryRepository;
import za.ac.cput.service.DeliveryHistoryService;

import java.util.List;

@Service
public class DeliveryHistoryServiceImpl implements DeliveryHistoryService {

    private DeliveryHistoryRepository repository;

    @Autowired
    private DeliveryHistoryServiceImpl(DeliveryHistoryRepository repository){this.repository = repository; }

    @Override
    public DeliveryHistory create(DeliveryHistory deliveryHistory) {
        return this.repository.save(deliveryHistory);
    }

    @Override
    public DeliveryHistory read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public DeliveryHistory update(DeliveryHistory deliveryHistory) {
        if(this.repository.existsById(deliveryHistory.getDeliveryOrderId())){
            return this.repository.save(deliveryHistory);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DeliveryHistory> getAll() {
        return this.repository.findAll();
    }
}
