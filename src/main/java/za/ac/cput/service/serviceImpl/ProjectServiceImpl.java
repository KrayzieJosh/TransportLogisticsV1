package za.ac.cput.service.serviceImpl;

import za.ac.cput.domain.Project;
import za.ac.cput.repository.ProjectRepository;
import za.ac.cput.repository.repositoryImpl.ProjectRepositoryImpl;
import za.ac.cput.service.ProjectService;

import java.util.Set;

public class ProjectServiceImpl implements ProjectService {

    private static ProjectService service = null;
    private ProjectRepository repository = null;

    private ProjectServiceImpl() { repository = ProjectRepositoryImpl.getRepository();}

    public static ProjectService getService() {
        if (service == null){
            service = new ProjectServiceImpl();
        }
        return service;
    }

    @Override
    public Project create(Project project) {
        Project created = repository.create(project);
        return created;
    }

    @Override
    public Project read(String projectId) {
        Project readProject = repository.read(projectId);
        return readProject;
    }

    @Override
    public Project update(Project project) {
        Project updateProject = repository.update(project);
        return updateProject;
    }

    @Override
    public boolean delete(String projectId) {
        boolean success = repository.delete(projectId);
        return success;
    }

    @Override
    public Set<Project> getAll() {
        return repository.getAll();
    }
}
