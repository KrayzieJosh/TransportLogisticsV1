package za.ac.cput.service;

import za.ac.cput.domain.Company;
import za.ac.cput.domain.Project;

import java.util.Set;

public interface ProjectService {

    Project create(Project project);
    Project read(String projectId);
    Project update(Project project);
    boolean delete(String projectId);
    public Set<Project> getAll();

}
