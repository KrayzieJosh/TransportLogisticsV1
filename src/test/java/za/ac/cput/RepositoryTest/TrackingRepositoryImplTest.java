package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Tracking;
import za.ac.cput.factory.TrackingFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TrackingRepositoryImplTest {

    private static TrackingRepositoryImpl repository = TrackingRepositoryImpl.getRepository();
    private static Tracking tracking = TrackingFactory.createTracker(Helper.generateID(),1, 2);

    @Test
    void a_create() {
        Tracking created = repository.create(tracking);
        assertEquals(tracking.getTripId(), created.getTripId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Tracking read = repository.read(tracking.getTripId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Tracking updated = new Tracking.Builder().copy(tracking).setStops(8)
                .build();
        //assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(tracking.getTripId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}