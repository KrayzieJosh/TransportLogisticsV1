package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.GPS;

import java.util.Set;

public interface GPSRepository extends JpaRepository<GPS,String> {
    public Set<GPS> getAll();
}
