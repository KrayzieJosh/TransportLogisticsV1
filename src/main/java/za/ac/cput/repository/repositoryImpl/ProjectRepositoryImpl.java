package za.ac.cput.repository.repositoryImpl;

import za.ac.cput.domain.Project;
import za.ac.cput.repository.ProjectRepository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProjectRepositoryImpl  implements ProjectRepository , Serializable {

    private static ProjectRepositoryImpl repository = null;
    private Set<Project> projectDB = null;

    private ProjectRepositoryImpl() {projectDB = new HashSet<>(); }

    public static ProjectRepositoryImpl getRepository(){
        if(repository == null){
            repository = new ProjectRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Project create(Project project) {
        boolean success = projectDB.add(project);
        if(!success)
            return null;
        return project;
    }

    @Override
    public Project read(String projectId) {
        for (Project p: projectDB){
            if(p.getProjectId().equals(projectId))
                return p;
        }
        return null;
    }

    @Override
    public Project update(Project project) {
        Project oldProject = read(project.getProjectId());
        if(oldProject != null){
            projectDB.remove(oldProject);
            projectDB.add(project);
            return project;
        }
        return null;
    }

    @Override
    public boolean delete(String projectId) {
        Project projectToDelete = read(projectId);
        if (projectToDelete == null){
            return false;
        }
        projectDB.remove(projectToDelete);
        return true;
    }

    @Override
    public Set<Project> getAll() {
        return projectDB;
    }

}
