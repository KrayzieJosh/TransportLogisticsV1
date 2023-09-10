package za.ac.cput.RepositoryTest;

/* CompanyRepositoryImplTest.java
 Package: RepositoryTest
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Company;
import za.ac.cput.factory.CompanyFactory;
import za.ac.cput.repository.repositoryImpl.CompanyRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CompanyRepositoryImplTest {

    private static CompanyRepositoryImpl repository = CompanyRepositoryImpl.getRepository();
    private static Company company = CompanyFactory.createCompany(Helper.generateID(), "OnRoute", "1A Berkin Street, Claremont",
            "021 703 4567","onroute@gmail.com");

    @Test
    void a_create() {
        Company created = repository.create(company);
        assertEquals(company.getCompanyId(), created.getCompanyId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Company read = repository.read(company.getCompanyId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Company updated = new Company.Builder().copy(company).setCompanyEmail("onroute003@gmail.com")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(company.getCompanyId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}
