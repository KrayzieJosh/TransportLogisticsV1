package za.ac.cput.repository.repositoryImpl;

/* DeliveryHistoryRepositoryImpl.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.repository.DeliveryHistoryRepository;

import java.util.HashSet;
import java.util.Set;

public class DeliveryHistoryRepositoryImpl implements DeliveryHistoryRepository {

    private static DeliveryHistoryRepositoryImpl repository = null;
    private Set<DeliveryHistory> deliveryHistoryDB;

    private DeliveryHistoryRepositoryImpl(){
        deliveryHistoryDB = new HashSet<DeliveryHistory>();
    }

    public static DeliveryHistoryRepositoryImpl getRepository(){
        if(repository == null){ repository = new DeliveryHistoryRepositoryImpl();}
        return repository;
    }

    @Override
    public DeliveryHistory create(DeliveryHistory deliveryHistory) {
        boolean success = deliveryHistoryDB.add(deliveryHistory);
        if(!success){
            return null;
        }
        return deliveryHistory;
    }

    @Override
    public DeliveryHistory read(String deliveryOrderId) {
        for(DeliveryHistory d : deliveryHistoryDB){
            if(d.getDeliveryOrderId().equals(deliveryOrderId)){
                return d;
            }
        }
        return null;
    }

    @Override
    public DeliveryHistory update(DeliveryHistory deliveryHistory) {
        DeliveryHistory oldDeliveryHistory = read(deliveryHistory.getDeliveryOrderId());
        if (oldDeliveryHistory != null){
            deliveryHistoryDB.remove(oldDeliveryHistory);
            deliveryHistoryDB.add(deliveryHistory);
            return deliveryHistory;
        }
        return null;
    }

    @Override
    public boolean delete(String deliveryOrderId) {
        DeliveryHistory deliveryHistoryToDelete = read(deliveryOrderId);
        if (deliveryHistoryToDelete == null){
            return false;
        }
        deliveryHistoryDB.remove(deliveryHistoryToDelete);
        return true;
    }

    @Override
    public Set<DeliveryHistory> getAll() {
        return deliveryHistoryDB;
    }

}

