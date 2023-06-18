package za.ac.cput.repository;

/* CompanyRepository.java
 Entity for the repository
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import za.ac.cput.domain.Company;

import java.util.Set;

public interface CompanyRepository extends IRepository<Company,String> {
    public Set<Company>getAll();
}
