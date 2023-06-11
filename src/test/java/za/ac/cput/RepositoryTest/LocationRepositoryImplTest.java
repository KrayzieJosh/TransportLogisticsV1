package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.repository.repositoryImpl.LocationRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationRepositoryImplTest {

    private static LocationRepositoryImpl repository = LocationRepositoryImpl.getRepository();
    private static Location location = LocationFactory.createLocation(Helper.generateID(), "BUCO", 5,"Avenue","Cape Town",213);

    @Test
    void a_create() {
        Location created = repository.create(location);
        assertEquals(location.getLocationId(), created.getLocationId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Location read = repository.read(location.getLocationId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Location updated = new Location.Builder().copy(location).setStreetNumber(8)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(location.getLocationId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}