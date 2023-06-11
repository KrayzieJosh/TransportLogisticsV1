package za.ac.cput.service;
import za.ac.cput.domain.Company;
import java.util.Set;
public interface CompanyService {
    Company create(Company company);
    Company read(String companyId);
    Company update(Company company);
    boolean delete(String companyId);
    public Set<Company>getAll();
}
