package za.ac.cput.repository;

import za.ac.cput.domain.SiteManager;

import java.util.Set;

public interface SiteManagerRepository {
    SiteManager create(SiteManager manager);

    SiteManager read(String userId);

    SiteManager update(SiteManager manager);

    boolean delete(String userId);

    public Set<SiteManager> getAll();

}
