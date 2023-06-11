package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectFactoryTest {

    @Test
    void createProjectAndSiteManagers() {
        List<ProjectManager>projectManager= Arrays.asList();
        List<SiteManager>siteManagers=Arrays.asList();
        Project project1= ProjectFactory.createProjectAndSiteManagers(
                Helper.generateID(),"construction manager","Done",projectManager,siteManagers);
        assertNotNull(project1);
        System.out.println(project1.toString());
    }
}