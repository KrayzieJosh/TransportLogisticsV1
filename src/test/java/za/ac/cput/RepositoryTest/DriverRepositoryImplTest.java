package za.ac.cput.RepositoryTest;

/* DriverRepositoryImplTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Project;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.repository.repositoryImpl.DriverRepositoryImpl;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DriverRepositoryImplTest {

    //Creating ArrayList:
    static Project project1 = ProjectFactory.createProject(Helper.generateID(), "Sky House Project", "Completed");
    static Project project2 = ProjectFactory.createProject(Helper.generateID(), "Blue Tower Project", "Almost Done");
    static ArrayList<Project> listOfProjects = new ArrayList<Project>(Arrays.asList( project1, project2));

    private static DriverRepositoryImpl repository = DriverRepositoryImpl.getRepository();
    private static Driver driver = DriverFactory.createNewDriver(Helper.generateID(), "Test Position", listOfProjects, Helper.generateID());

    @Test
    void a_create() {
        Driver created = repository.create(driver);
        assertEquals(driver.getUserId(), created.getUserId());
        System.out.println("Create: "+created);
    }

    @Test
    void b_read() {
        Driver read = repository.read(driver.getUserId());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update(){
        Driver updated = new Driver.Builder().copy(driver).setUserPosition("Manager position").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+updated);
    }

    @Test
    void e_delete(){
        boolean success = repository.delete(driver.getUserId());
        assertTrue(success);
        System.out.println("Delete: "+success);
    }

    @Test
    void d_getAll(){
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }

}
