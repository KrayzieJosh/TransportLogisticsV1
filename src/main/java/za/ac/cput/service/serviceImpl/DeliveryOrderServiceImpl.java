package za.ac.cput.service.serviceImpl;
/*
   Entity for DeliveryOrderServiceImpl
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.repository.DeliveryOrderRepository;
import za.ac.cput.repository.repositoryImpl.DeliveryOrderRepositoryImpl;
import za.ac.cput.service.DeliveryOrderService;

import java.util.Set;

public class DeliveryOrderServiceImpl implements DeliveryOrderService {
    private static DeliveryOrderService service = null;
    private DeliveryOrderRepository repository = null;

    private DeliveryOrderServiceImpl() {
        repository = DeliveryOrderRepositoryImpl.getRepository();
    }

    public static DeliveryOrderService getService() {
        if (service == null) {
            service = new DeliveryOrderServiceImpl();
        }
        return service;
    }

    @Override
    public DeliveryOrder create(DeliveryOrder deliveryOrder) {
        DeliveryOrder created = repository.create(deliveryOrder);
        return created;
    }

    @Override
    public DeliveryOrder read(String deliveryOrderId) {
        DeliveryOrder readDeliveryOrder = repository.read(deliveryOrderId);
        return readDeliveryOrder;
    }

    @Override
    public DeliveryOrder update(DeliveryOrder deliveryOrder) {
        DeliveryOrder updatedDeliveryOrder = repository.update(deliveryOrder);
        return updatedDeliveryOrder;
    }

    @Override
    public boolean delete(String deliveryOrderId) {
        boolean success = repository.delete(deliveryOrderId);
        return success;
    }

    @Override
    public Set<DeliveryOrder> getAll() {
        return repository.getAll();
    }
}
