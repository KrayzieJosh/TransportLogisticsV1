package za.ac.cput.repository;

import za.ac.cput.domain.ProjectManager;

import java.util.List;
import java.util.Set;

public interface ProjectManagerRepository {
    ProjectManager create(ProjectManager manager);

    ProjectManager read(String userId);

    ProjectManager update(ProjectManager manager);

    boolean delete(String userId);

    public Set<ProjectManager> getAll();

}
