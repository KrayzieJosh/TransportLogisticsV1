package za.ac.cput.service.serviceImpl;


/* CompanyServiceImpl.java
 Entity for the serviceImpl
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/


import za.ac.cput.domain.Company;
import za.ac.cput.repository.CompanyRepository;
import za.ac.cput.repository.repositoryImpl.CompanyRepositoryImpl;
import za.ac.cput.service.CompanyService;

import java.util.Set;

public class CompanyServiceImpl implements CompanyService {
    private static CompanyService service = null;
    private CompanyRepository repository = null;

    private CompanyServiceImpl() {
        repository = CompanyRepositoryImpl.getRepository();
    }

    public static CompanyService getService() {
        if (service == null) {
            service = new CompanyServiceImpl();
        }
        return service;
    }

    @Override
    public Company create(Company company) {
        Company created = repository.create(company);
        return created;
    }

    @Override
    public Company read(String companyId) {
        Company readCompany = repository.read(companyId);
        return readCompany;
    }

    @Override
    public Company update(Company company) {
        Company updateCompany = repository.update(company);
        return updateCompany;
    }
    @Override
    public boolean delete(String companyId){
        boolean success =repository.delete(companyId);
        return success;
    }
    @Override
    public Set<Company> getAll () {
        return repository.getAll();


    }
}
