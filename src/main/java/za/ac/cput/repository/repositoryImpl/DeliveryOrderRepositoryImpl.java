package za.ac.cput.repository.repositoryImpl;
/*
   Entity for DeliveryOrderRepositoryImpl
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import java.util.HashSet;
import java.util.Set;

import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.repository.DeliveryOrderRepository;

public class DeliveryOrderRepositoryImpl implements DeliveryOrderRepository {
    private static DeliveryOrderRepositoryImpl repository = null;
    private Set<DeliveryOrder> deliveryOrderDB = null;

    private DeliveryOrderRepositoryImpl() {
        deliveryOrderDB = new HashSet<>();
    }

    public static DeliveryOrderRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new DeliveryOrderRepositoryImpl();
        }
        return repository;
    }

    @Override
    public DeliveryOrder create(DeliveryOrder deliveryOrder) {
        boolean success = deliveryOrderDB.add(deliveryOrder);
        if (!success)
            return null;
        return deliveryOrder;
    }

    @Override
    public DeliveryOrder read(String deliveryOrderId) {
        for (DeliveryOrder d : deliveryOrderDB) {
            if (d.getDeliveryOrderId().equals(deliveryOrderId))
                return d;
        }
        return null;
    }

    @Override
    public DeliveryOrder update(DeliveryOrder deliveryOrder) {
        DeliveryOrder oldDeliveryOrder = read(deliveryOrder.getDeliveryOrderId());
        if (oldDeliveryOrder != null) {
            deliveryOrderDB.remove(oldDeliveryOrder);
            deliveryOrderDB.add(deliveryOrder);
            return deliveryOrder;
        }
        return null;
    }

    @Override
    public boolean delete(String deliveryOrderId) {
        DeliveryOrder deliveryOrderToDelete = read(deliveryOrderId);
        if (deliveryOrderToDelete == null) {
            return false;
        }
        deliveryOrderDB.remove(deliveryOrderToDelete);
        return true;
    }

    @Override
    public Set<DeliveryOrder> getAll() {
        return deliveryOrderDB;
    }
}
