package za.ac.cput.service;

import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.domain.Driver;

import java.util.Set;

public interface DeliveryHistoryService {

    DeliveryHistory create(DeliveryHistory deliveryHistory);
    DeliveryHistory read(String deliveryOrderId);
    DeliveryHistory update(DeliveryHistory deliveryHistory);
    public Set<DeliveryHistory> getAll();

}
