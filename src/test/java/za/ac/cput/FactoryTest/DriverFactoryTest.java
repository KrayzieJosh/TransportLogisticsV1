package za.ac.cput.FactoryTest;

/* DriverFactoryTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Project;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

public class DriverFactoryTest extends TestCase {

    ArrayList<Project> listOfProjects = new ArrayList<Project>(Arrays.asList( new Project(Helper.generateID(), "HillSong Project","Almost done"),
                                                                        new Project(Helper.generateID(), "Red Flag Project", "Must Started")));

    @Test
    public void testCreateNewDriver() {

        Driver driver = DriverFactory.createNewDriver(Helper.generateID(), "Test Position", listOfProjects, Helper.generateID());
        assertNotNull(driver);
        driver.toString();
        System.out.println(driver);
    }
}
