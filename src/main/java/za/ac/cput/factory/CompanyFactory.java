package za.ac.cput.factory;


/* CompanyFactory.java
 Entity for the factory
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import za.ac.cput.domain.Company;
import za.ac.cput.util.Helper;

public class CompanyFactory {
    public static Company createCompany(String companyId,String companyName,String companyAddress,String companyContact,String companyEmail) {
        companyId = Helper.generateID();


        if (Helper.isNullOrEmpty(companyId) || Helper.isNullOrEmpty(companyName) || Helper.isNullOrEmpty(companyAddress)
                || Helper.isNullOrEmpty(companyContact) || Helper.isNullOrEmpty(companyEmail)) {
            return null;
         }

            return new Company.Builder()
                .setCompanyId(companyId)
                .setCompanyName(companyName)
                .setCompanyAddress(companyAddress)
                .setCompanyContact(companyContact)
                .setCompanyEmail(companyEmail)
                .build();
    }
}
