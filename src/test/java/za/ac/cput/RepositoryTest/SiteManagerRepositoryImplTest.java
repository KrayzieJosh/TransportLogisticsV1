package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.repository.repositoryImpl.SiteManagerRepositoryImpl;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class SiteManagerRepositoryImplTest {

    private static SiteManagerRepositoryImpl siteManagerRepository= SiteManagerRepositoryImpl.getSiteManagerRepository();
    private static List<Project> projects= Arrays.asList();
    private static SiteManager manager= SiteManagerFactory.createSiteManager( Helper.generateID(),"Construction Manager",projects);
    @Test
    void a_create() {
        SiteManager created= siteManagerRepository.create(manager);
        assertEquals(manager.getUserId(),created.getUserId());
        System.out.println("Create" + created);
    }

    @Test
    void b_read() {
        SiteManager read= siteManagerRepository.read(manager.getUserId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        SiteManager updated=new SiteManager.SiteManagerBuilder().copy(manager).setUserId(Helper.generateID()).setUserPosition("Foreman")
                .setUserProjects(projects).build();
        assertNotNull(siteManagerRepository.update(updated));
        System.out.println("Update " + updated);
    }

    @Test
    void e_delete() {
        boolean success = siteManagerRepository.delete(manager.getUserId());
        assertTrue(success);
        System.out.println("Delete:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(siteManagerRepository.getAll());
    }
}