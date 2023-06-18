package za.ac.cput.repository;
/*
   Entity for DeliveryOrderRepository
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/

import za.ac.cput.domain.DeliveryOrder;

import java.util.Set;

public interface DeliveryOrderRepository extends IRepository<DeliveryOrder,String> {
    public Set<DeliveryOrder>getAll();
}
