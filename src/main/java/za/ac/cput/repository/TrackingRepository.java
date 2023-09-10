package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import za.ac.cput.domain.Tracking;

import java.util.Set;

public interface TrackingRepository extends JpaRepository<Tracking,String> {
    public Set<Tracking> getAll();
}
