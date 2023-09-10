package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.repository.LocationRepository;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationRepositoryImplTest {

    @Autowired
    private LocationRepository repository;

    private Location location = LocationFactory.createLocation(Helper.generateID(), "BUCO", 5, "Avenue", "Cape Town", 213);

    @Test
    void a_create() {
        Location created = repository.save(location);
        assertEquals(location.getLocationId(), created.getLocationId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Location read = repository.findById(location.getLocationId()).orElse(null);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Location updated = new Location.Builder().copy(location).setStreetNumber(8)
                .build();
        // assertNotNull(repository.save(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        repository.deleteById(location.getLocationId());
        boolean exists = repository.existsById(location.getLocationId());
        assertFalse(exists);
        System.out.println("Delete: " + !exists);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.findAll());
    }
}
