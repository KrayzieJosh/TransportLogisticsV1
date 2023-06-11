package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Project;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.repository.repositoryImpl.ProjectRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ProjectRepositoryImplTest {

    private static ProjectRepositoryImpl repository = ProjectRepositoryImpl.getRepository();
    private static Project project = ProjectFactory.createProject(Helper.generateID(), "Sky House Project", "Completed");

    @Test
    void a_create() {
        Project created = repository.create(project);
        assertEquals(project.getProjectId(), created.getProjectId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Project read = repository.read(project.getProjectId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Project updated = new Project.ProjectBuilder().copy(project).setProjectName("The Crop Duster Project").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(project.getProjectId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}