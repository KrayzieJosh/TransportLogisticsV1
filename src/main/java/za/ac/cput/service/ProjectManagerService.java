package za.ac.cput.service;

import za.ac.cput.domain.ProjectManager;

import java.util.Set;

public interface ProjectManagerService {

    ProjectManager create(ProjectManager manager);

    ProjectManager read(String userId);

    ProjectManager update(ProjectManager manager);

    boolean delete(String userId);

    public Set<ProjectManager> getAll();
}
