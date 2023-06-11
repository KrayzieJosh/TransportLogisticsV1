package za.ac.cput.service;

import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;

import java.util.Set;

public interface SiteManagerService {


    SiteManager create(SiteManager manager);

    SiteManager read(String userId);

    SiteManager update(SiteManager manager);

    boolean delete(String userId);

    Set<SiteManager> getAll();
}
