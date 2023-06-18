package za.ac.cput.service.serviceImpl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.repository.SiteManagerRepository;
import za.ac.cput.repository.repositoryImpl.SiteManagerRepositoryImpl;
import za.ac.cput.service.SiteManagerService;

import java.io.Serializable;
import java.util.Set;
@Service
public class SiteManagerServiceImpl implements SiteManagerService, Serializable {
    private static SiteManagerService service = null;
    private SiteManagerRepository repository;

    private SiteManagerServiceImpl(){
        repository= SiteManagerRepositoryImpl.getSiteManagerRepository();

    }
    public static SiteManagerService getService(){

        if (service == null) {
            service = new SiteManagerServiceImpl();
        }
        return service;
    }
    @Override
    public SiteManager create(SiteManager manager) {
        SiteManager created = repository.create(manager);
        return created;
    }

    @Override
    public SiteManager read(String userId) {
        SiteManager readSiteManager = repository.read(userId);
        return readSiteManager;
    }

    @Override
    public SiteManager update(SiteManager manager) {
        SiteManager updateSiteManager = repository.update(manager);
        return updateSiteManager;
    }
    @Override
    public boolean delete(String userId){
        boolean success =repository.delete(userId);
        return success;
    }
    @Override
    public Set<SiteManager> getAll() {
        return repository.getAll();
    }
}
