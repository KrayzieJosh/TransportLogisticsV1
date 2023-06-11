package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.GPS;
import za.ac.cput.factory.GPSFactory;
import za.ac.cput.repository.repositoryImpl.GPSRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GPSRepositoryImplTest {

    private static GPSRepositoryImpl repository = GPSRepositoryImpl.getRepository();
    private static GPS gps = GPSFactory.createGPS(Helper.generateID(), "1111-4568-9635", "1789-9654-14203");

    @Test
    void a_create() {
        GPS created = repository.create(gps);
        assertEquals(gps.getTripId(), created.getTripId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        GPS read = repository.read(gps.getTripId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        GPS updated = new GPS.Builder().copy(gps).setStartLocationId("111-456-63")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(gps.getTripId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}
