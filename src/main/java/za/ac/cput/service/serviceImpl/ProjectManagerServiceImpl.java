package za.ac.cput.service.serviceImpl;

import za.ac.cput.domain.ProjectManager;
import za.ac.cput.repository.ProjectManagerRepository;
import za.ac.cput.repository.repositoryImpl.ProjectManagerRepositoryImpl;
import za.ac.cput.service.ProjectManagerService;

import java.util.Set;

public class ProjectManagerServiceImpl implements ProjectManagerService {

    private static ProjectManagerService service = null;
    private ProjectManagerRepository repository = null;

   private ProjectManagerServiceImpl(){
       repository= ProjectManagerRepositoryImpl.getProjectManagerRepository();

   }
   public static ProjectManagerService getService(){

       if (service == null) {
           service = new ProjectManagerServiceImpl();
       }
       return service;
   }
    @Override
    public ProjectManager create(ProjectManager manager) {
        ProjectManager created = repository.create(manager);
        return created;
    }

    @Override
    public ProjectManager read(String userId) {
        ProjectManager readProjectManager = repository.read(userId);
        return readProjectManager;
    }

    @Override
    public ProjectManager update(ProjectManager manager) {
        ProjectManager updateProjectManager = repository.update(manager);
        return updateProjectManager;
    }
    @Override
    public boolean delete(String userId){
        boolean success =repository.delete(userId);
        return success;
    }
    @Override
    public Set<ProjectManager> getAll() {
        return null;
    }
}
