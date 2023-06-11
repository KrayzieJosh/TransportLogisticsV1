package za.ac.cput.ServiceTest;

/* CompanyServiceImplTest.java
 Package: ServiceTest
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Company;
import za.ac.cput.factory.CompanyFactory;
import za.ac.cput.service.CompanyService;
import za.ac.cput.service.serviceImpl.CompanyServiceImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class CompanyServiceImplTest {
    private static CompanyService service=null;

    public static Company company= CompanyFactory.createCompany(Helper.generateID(), "OnRoute", "1A Berkin Street, Seapoint"
            , "021 703 4567", "onroute@gmail.com");
    public CompanyServiceImplTest(){

        service=  CompanyServiceImpl.getService();
    }

    @Test
    void a_create() {
        Company created=service.create(company);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        Company read = service.read(company.getCompanyId());
        System.out.println("Read: "+read);
        assertNotNull(read);

    }

    @Test
    void c_update() {
        Company updated = new Company.Builder().copy(company).setCompanyName("LoadUp")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete(){
        String id=company.getCompanyId();
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
