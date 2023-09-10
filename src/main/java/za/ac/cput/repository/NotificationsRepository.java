package za.ac.cput.repository;
/* NotificationsRepository.java
 Entity for the repository
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Notifications;

import java.util.Set;
@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, String> {

}
