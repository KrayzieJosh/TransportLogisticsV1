package za.ac.cput.ServiceTest;

/* DriverServiceImplTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Project;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.service.DriverService;
import za.ac.cput.service.serviceImpl.DriverServiceImpl;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DriverServiceImplTest {

    //arraylist:
    static ArrayList<Project> listOfProjects = new ArrayList<Project>(Arrays.asList( new Project(Helper.generateID(), "HillSong Project","Almost done"),
            new Project(Helper.generateID(), "Red Flag Project", "Must Started")));


    private static DriverService service = null;

    public static Driver driver = DriverFactory.createNewDriver(Helper.generateID(), "Test position", listOfProjects, Helper.generateID());

    public DriverServiceImplTest(){

        service = DriverServiceImpl.getService();
    }

    @Test
    void a_create() {
        Driver created = service.create(driver);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        Driver read = service.read(driver.getUserId());
        System.out.println("Read: "+read);
        assertNotNull(read);
    }

    @Test
    void c_update() {
        Driver updated = new Driver.Builder().copy(driver).setVehicleId(Helper.generateID()).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete() {
        String id = driver.getUserId();
        boolean success = service.delete(id);
        assertTrue(success);
        System.out.println("Success: "+ success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}