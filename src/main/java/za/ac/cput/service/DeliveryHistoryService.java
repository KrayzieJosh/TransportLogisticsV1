package za.ac.cput.service;

import za.ac.cput.domain.DeliveryHistory;

import java.util.List;

public interface DeliveryHistoryService extends IService<DeliveryHistory, String>{
    List<DeliveryHistory> getAll();
}
