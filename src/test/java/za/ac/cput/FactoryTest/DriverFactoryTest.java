package za.ac.cput.FactoryTest;

/* DriverFactoryTest.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

public class DriverFactoryTest extends TestCase {

    @Test
    public void testCreateNewDriver() {

        Driver driver = DriverFactory.createNewDriver("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver", Helper.generateID());
        assertNotNull(driver);
        driver.toString();
        System.out.println(driver);
    }
}
