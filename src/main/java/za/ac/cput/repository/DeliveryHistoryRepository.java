package za.ac.cput.repository;

/* DeliveryHistory.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import java.util.Set;

import za.ac.cput.domain.DeliveryHistory;

public interface DeliveryHistoryRepository extends IRepository<DeliveryHistory, String> {

    public Set<DeliveryHistory> getAll();
}

