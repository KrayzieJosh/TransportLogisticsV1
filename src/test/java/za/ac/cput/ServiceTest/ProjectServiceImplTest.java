package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Project;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.service.ProjectService;
import za.ac.cput.service.serviceImpl.ProjectServiceImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProjectServiceImplTest {

    private static ProjectService service=null;

    public static Project project= ProjectFactory.createProject(Helper.generateID(), "Project2", "Done"
            );

    public ProjectServiceImplTest(){

        service= ProjectServiceImpl.getService();
    }
    @Test
    void a_create() {
        Project created=service.create(project);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        Project read = service.read(project.getProjectId());
        System.out.println("Read: "+read);
        assertNotNull(read);
    }

    @Test
    void c_update() {

        Project updated = new Project.ProjectBuilder().copy(project).setProjectStatus("In progress")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete() {
        String id=project.getProjectId();
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