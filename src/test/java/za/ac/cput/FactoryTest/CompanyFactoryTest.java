package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Company;
import za.ac.cput.factory.CompanyFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class CompanyFactoryTest {

    @Test
    public void createCompany() {
        Company company =  CompanyFactory.createCompany
                (Helper.generateID(),"OnRoute","1A Berkin Street, Seapoint"
                        ,"021 703 4567", "onroute@gmail.com");

        assertNotNull(company);
        System.out.println(company.toString());

    }
}