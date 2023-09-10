package za.ac.cput.service;

/* CompanyService.java
 Entity for the service
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import za.ac.cput.domain.Company;
import java.util.Set;
public interface CompanyService {
    Company create(Company company);
    Company read(String companyId);
    Company update(Company company);
    boolean delete(String companyId);
    public Set<Company>getAll();
}
