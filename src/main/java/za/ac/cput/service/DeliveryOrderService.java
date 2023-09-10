package za.ac.cput.service;
/*
   Entity for DeliveryOrderService
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import za.ac.cput.domain.DeliveryOrder;

import java.util.List;

public interface DeliveryOrderService {

    DeliveryOrder create(DeliveryOrder deliveryOrder);

    DeliveryOrder read(String deliveryOrderId);

    DeliveryOrder update(DeliveryOrder deliveryOrder);

    boolean delete(String deliveryOrderId);

    List<DeliveryOrder> getAll();
}
