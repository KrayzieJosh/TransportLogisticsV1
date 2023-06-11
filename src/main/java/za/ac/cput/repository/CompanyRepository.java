package za.ac.cput.repository;
import za.ac.cput.domain.Company;

import java.util.Set;

public interface CompanyRepository extends IRepository<Company,String> {
    public Set<Company>getAll();
}
