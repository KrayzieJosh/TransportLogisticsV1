package za.ac.cput.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Project;
import za.ac.cput.repository.ProjectRepository;
import za.ac.cput.service.ProjectService;
import java.util.List;
import java.io.Serializable;

@Service
public class ProjectServiceImpl implements ProjectService , Serializable {

    private ProjectRepository repository;
    @Autowired
    private ProjectServiceImpl(ProjectRepository  repository) {
        this.repository=repository;

    }
    @Override
    public Project create(Project project) {
        return this.repository.save(project);

    }
    @Override
    public Project read(String projectID){
        return this.repository.findById(projectID).orElse(null);

    }



    @Override
    public Project update(Project project){
        if(this.repository.existsById(project.getProjectId()))
            return this.repository.save(project);
        return null;
    }
    @Override
    public boolean delete(String projectID){
        if (this.repository.existsById(projectID)){
            this.repository.deleteById(projectID);
            return true;
        }
        return false;
    }
    @Override
    public List<Project> getAll(){
        return this.repository.findAll();
    }
}