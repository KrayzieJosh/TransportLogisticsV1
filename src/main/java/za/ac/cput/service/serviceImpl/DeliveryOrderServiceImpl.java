package za.ac.cput.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.repository.DeliveryOrderRepository;
import za.ac.cput.service.DeliveryOrderService;

import java.util.List;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

    private final DeliveryOrderRepository repository;

    @Autowired
    public DeliveryOrderServiceImpl(DeliveryOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryOrder create(DeliveryOrder deliveryOrder) {
        return repository.save(deliveryOrder);
    }

    @Override
    public DeliveryOrder read(String deliveryOrderId) {
        return repository.findById(deliveryOrderId).orElse(null);
    }

    @Override
    public DeliveryOrder update(DeliveryOrder deliveryOrder) {
        if (repository.existsById(deliveryOrder.getDeliveryOrderId())) {
            return repository.save(deliveryOrder);
        }
        return null;
    }

    @Override
    public boolean delete(String deliveryOrderId) {
        if (repository.existsById(deliveryOrderId)) {
            repository.deleteById(deliveryOrderId);
            return true;
        }
        return false;
    }

    @Override
    public List<DeliveryOrder> getAll() {
        return repository.findAll();
    }
}
