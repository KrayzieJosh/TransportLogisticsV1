package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.DeliveryHistory;

@Repository
public interface DeliveryHistoryRepository extends JpaRepository<DeliveryHistory, String> {

}
