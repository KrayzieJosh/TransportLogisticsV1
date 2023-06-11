package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.service.LocationService;
import za.ac.cput.service.serviceImpl.LocationServiceImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class LocationServiceImplTest {
    private static LocationService service=null;

    public static Location location= LocationFactory.createLocation(Helper.generateID(), "Builders Warehouse", 11,"Stand road","Cape Town",2345);
    public LocationServiceImplTest(){

        service=  LocationServiceImpl.getService();
    }

    @Test
    void a_create() {
        Location created=service.create(location);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        Location read = service.read(location.getLocationId());
        System.out.println("Read: "+read);
        assertNotNull(read);

    }

    @Test
    void c_update() {
        Location updated = new Location.Builder().copy(location).setName("Brights")
                .build();
        //assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete(){
        String id= location.getLocationId();
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