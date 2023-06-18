package za.ac.cput.repository.repositoryImpl;

import za.ac.cput.domain.SiteManager;
import za.ac.cput.repository.SiteManagerRepository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SiteManagerRepositoryImpl implements SiteManagerRepository, Serializable {
    private static SiteManagerRepositoryImpl siteManagerRepository=null;
    private Set<SiteManager> siteManagerDb=null;
    private SiteManagerRepositoryImpl(){
        siteManagerDb=new HashSet<SiteManager>();

    }
    public static SiteManagerRepositoryImpl getSiteManagerRepository(){
        if(siteManagerRepository==null){
            siteManagerRepository= new SiteManagerRepositoryImpl();

        }
        return siteManagerRepository;
    }

    @Override
    public SiteManager create(SiteManager manager){
        boolean success= siteManagerDb.add(manager);
        if(!success){
            return null;


        }
        return manager;
    }
    @Override
    public SiteManager read(String userId){
        for(SiteManager manager:siteManagerDb){
            if(manager.getUserId().equals(userId));
            return manager;


        }
        return null;

    }
    @Override
    public SiteManager update(SiteManager manager){
        SiteManager oldSiteManager=read(manager.getUserId());
        if(oldSiteManager!=null){
            siteManagerDb.remove(oldSiteManager);
            siteManagerDb.add(manager);
            return manager;

        }
        return null;
    }

    @Override
    public boolean delete(String userId){
        SiteManager deleteSiteManager= read(userId);
        if(deleteSiteManager==null){
            return false;

        }
        siteManagerDb.remove(deleteSiteManager);
        return true;
    }





        public Set<SiteManager> getAll() {
        return siteManagerDb;
    }
}
