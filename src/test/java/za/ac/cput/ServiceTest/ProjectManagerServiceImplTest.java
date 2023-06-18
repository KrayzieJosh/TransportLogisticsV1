package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Company;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.service.CompanyService;
import za.ac.cput.service.ProjectManagerService;
import za.ac.cput.service.serviceImpl.ProjectManagerServiceImpl;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class ProjectManagerServiceImplTest {

    private static ProjectManagerService service=null;
    private static List<Project> projects= Arrays.asList();
    private static List<SiteManager> managers=Arrays.asList();

    public static ProjectManager manager= ProjectManagerFactory.createProjectManager(Helper.generateID(),"Unavailable",projects,managers);
    public ProjectManagerServiceImplTest(){

        service= ProjectManagerServiceImpl.getService();
    }
    @Test
    void a_create() {
        ProjectManager created=service.create(manager);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        ProjectManager read = service.read(manager.getUserId());
        System.out.println("Read: "+read);
        assertNotNull(read);
    }

    @Test
    void c_update() {
        ProjectManager updated = new ProjectManager.ProjectManagerBuilder().copy(manager).setUserPosition("Fired").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete() {
        String id= manager.getUserId();
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