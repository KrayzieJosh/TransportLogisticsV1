package za.ac.cput.FactoryTest;

/* DriverFactoryTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

public class DriverFactoryTest extends TestCase {

    //Creating ArrayList:
    Project project1 = new ProjectFactory(Helper.generateID(), "Code Red Project", "Almost Done");
    Project project2 = new ProjectFactory(Helper.generateID(), "Sky House Project", "Completed");
    ArrayList<Project> listOfProjects = new ArrayList<Project>(Arrays.asList( project1, project2));

    @Test
    public void testCreateNewDriver() {

        Driver driver = DriverFactory.createNewDriver(Helper.generateID(), "Test Position", listOfProjects, Helper.generateID());
        assertNotNull(driver);
        driver.toString();
        System.out.println(driver);
    }
}
