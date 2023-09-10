package za.ac.cput.service;

import za.ac.cput.domain.Project;
import java.util.List;

public interface ProjectService {
    Project create(Project project);


    Project read(String projectID);

    Project update(Project project);

    boolean delete(String projectID);

    List<Project> getAll();
}