package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Tracking;
import za.ac.cput.factory.TrackingFactory;
import za.ac.cput.service.TrackingService;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Use Spring Boot's test support to enable Spring context
@TestMethodOrder(MethodOrderer.MethodName.class)
class TrackingServiceImplTest {

    @Autowired
    private TrackingService service; // Inject the TrackingService bean

    private static Tracking tracking = TrackingFactory.createTracker(Helper.generateID(), 1, 11);

    @Test
    void a_create() {
        Tracking created = service.create(tracking);
        System.out.println("Create: " + created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        Tracking read = service.read(tracking.getTripId());
        System.out.println("Read: " + read);
        assertNotNull(read);
    }

    @Test
    void c_update() {
        Tracking updated = new Tracking.Builder().copy(tracking).setDetours(7)
                .build();
        //assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        String id = tracking.getTripId();
        boolean success = service.delete(id);
        assertTrue(success);
        System.out.println("Success: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
