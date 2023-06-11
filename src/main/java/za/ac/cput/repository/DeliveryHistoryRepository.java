package za.ac.cput.repository;

import java.util.Set;

import za.ac.cput.domain.DeliveryHistory;

public interface DeliveryHistoryRepository extends IRepository<DeliveryHistory, String> {

    public Set<DeliveryHistory> getAll();
}

