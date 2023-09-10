package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProjectManagerRepositoryImplTest {
private static ProjectManagerRepositoryImpl projectManagerRepository= ProjectManagerRepositoryImpl.getProjectManagerRepository();
private static List<Project> projects= Arrays.asList(ProjectFactory.createProject(Helper.generateID(), "Sky House Project", "Completed"));

private static List<SiteManager> managers=Arrays.asList(SiteManagerFactory.createSiteManager(
        Helper.generateID(),"construction manager",projects));

private static ProjectManager manager= ProjectManagerFactory.createProjectManager( Helper.generateID(),"Foreman",projects,managers);


    @Test
    void a_create() {
    ProjectManager created= projectManagerRepository.create(manager);
    assertEquals(manager.getUserId(),created.getUserId());
        System.out.println("Create" + created);
    }

    @Test
    void b_read() {
        ProjectManager read= projectManagerRepository.read(manager.getUserId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
     ProjectManager updated=new ProjectManager.ProjectManagerBuilder().copy(manager).setUserId(Helper.generateID()).setUserProjects(projects)
             .setUserPosition("Manager").build();
     assertNotNull(projectManagerRepository.update(updated));
        System.out.println("Update " + updated);
    }

    @Test
    void e_delete() {
        boolean success = projectManagerRepository.delete(manager.getUserId());
        assertTrue(success);
        System.out.println("Delete:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(projectManagerRepository.getAll());
    }
}