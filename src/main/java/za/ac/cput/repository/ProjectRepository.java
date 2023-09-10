package za.ac.cput.repository;

import za.ac.cput.domain.Project;

import java.util.Set;

public interface ProjectRepository extends IRepository<Project,String>  {

    public Set<Project> getAll();
}
