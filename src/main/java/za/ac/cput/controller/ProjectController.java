package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.service.ProjectManagerService;
import za.ac.cput.service.ProjectService;

import java.util.Set;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/create")
    public Project create(@RequestBody Project project){


        Project newProject= ProjectFactory.createProject(project.getProjectId(),
                project.getProjectName(),project.getProjectStatus());
        return projectService.create(newProject);

    }
    @GetMapping("/read/{id}")
    public Project read(@PathVariable String id){
        return projectService.read(id);

    }
    @PostMapping("/update")
    public Project update(@RequestBody Project project){
        return projectService.update(project);

    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return projectService.delete(id);

    }
    @GetMapping("/getall")
    public Set<Project> getAll(){
        return projectService.getAll();

    }
}
