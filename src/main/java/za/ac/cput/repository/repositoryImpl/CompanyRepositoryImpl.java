package za.ac.cput.repository.repositoryImpl;

/* CompanyRepositoryImpl.java
 Entity for the repositoryImpl
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.domain.Company;
import za.ac.cput.repository.CompanyRepository;

public class CompanyRepositoryImpl implements CompanyRepository {
    private static CompanyRepositoryImpl repository = null;
    private Set<Company> companyDB = null;
    private CompanyRepositoryImpl(){
        companyDB = new HashSet<>();
    }
    public static CompanyRepositoryImpl getRepository(){
        if(repository == null){
            repository = new CompanyRepositoryImpl();
        }
        return repository;
    }
    @Override

    public Company create(Company company){
        boolean success = companyDB.add(company);
        if(!success)
            return null;
        return company;
    }
    @Override
    public Company read(String companyId){
        for (Company c: companyDB){
            if(c.getCompanyId().equals(companyId))
                return c;
        }
       return null;
    }
    @Override
    public Company update(Company company){
        Company oldCompany = read(company.getCompanyId());
        if(oldCompany != null){
            companyDB.remove(oldCompany);
            companyDB.add(company);
            return company;
        }
        return null;
    }
    @Override
    public boolean delete(String companyId){
        Company companyToDelete = read(companyId);
                if(companyToDelete == null){
                    return false;
                }
                companyDB.remove(companyToDelete);
                return true;
    }
    @Override
    public Set<Company>getAll(){
        return companyDB;
    }
}
