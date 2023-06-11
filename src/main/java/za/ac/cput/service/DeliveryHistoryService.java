package za.ac.cput.service;

/* DeliveryHistoryService.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.domain.Driver;

import java.util.Set;

public interface DeliveryHistoryService {

    DeliveryHistory create(DeliveryHistory deliveryHistory);
    DeliveryHistory read(String deliveryOrderId);
    DeliveryHistory update(DeliveryHistory deliveryHistory);
    public Set<DeliveryHistory> getAll();

}
