package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.GPS;
import za.ac.cput.factory.GPSFactory;
import za.ac.cput.service.GPSService;
import za.ac.cput.service.serviceImpl.GPSServiceImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class GPSServiceImplTest {
    private static GPSService service=null;

    public static GPS gps= GPSFactory.createGPS(Helper.generateID(), "456-789-123", "654-987-321");
    public GPSServiceImplTest(){

        service=  GPSServiceImpl.getService();
    }

    @Test
    void a_create() {
        GPS created=service.create(gps);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        GPS read = service.read(gps.getTripId());
        System.out.println("Read: "+read);
        assertNotNull(read);

    }

    @Test
    void c_update() {
        GPS updated = new GPS.Builder().copy(gps).setStoreLocationId("789-789-456")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete(){
        String id=gps.getTripId();
        boolean success=service.delete(id);
        assertTrue(success);
        System.out.println("Success: "+ success);
    }
    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}