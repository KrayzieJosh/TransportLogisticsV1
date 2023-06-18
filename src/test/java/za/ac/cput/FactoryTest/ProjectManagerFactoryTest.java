package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectManagerFactoryTest {

    @Test
    public void createProjectManager() {
        List<Project> projects= Arrays.asList(ProjectFactory.createProject(Helper.generateID(),"Project1","In progress"));
        List<SiteManager> managers=Arrays.asList(SiteManagerFactory.createSiteManager(
                Helper.generateID(),"construction manager",projects));
        ProjectManager manager= ProjectManagerFactory.createProjectManager(
                Helper.generateID(),"Foreman",projects,managers);
assertNotNull(manager);
        System.out.println(manager.toString());


    }

}