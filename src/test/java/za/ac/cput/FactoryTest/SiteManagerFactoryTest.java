package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SiteManagerFactoryTest {

    @Test
    public void createSiteManager() {

        List<Project> projects= Arrays.asList();


        SiteManager manager= SiteManagerFactory.createSiteManager(
                Helper.generateID(),"construction manager",projects);
        assertNotNull(manager);
        System.out.println(manager.toString());

    }
}