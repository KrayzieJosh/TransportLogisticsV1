package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Project;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.service.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.util.Helper;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/create")
    public Project create(@RequestBody Project project){
        return projectService.create(project);

    }  @GetMapping("/read/{projectID}")
    public Project read(@PathVariable String projectID)
    {

        return projectService.read(projectID);
    }
    @PostMapping("/update")
    public Project update(@RequestBody Project project){
        return projectService.update(project);

    }
    @DeleteMapping("/delete/{projectID}")
    public boolean delete(@PathVariable String projectID){
        return projectService.delete(projectID);

    }
    @GetMapping("/getall")
    public List<Project> getAll(){
        return projectService.getAll();
    }

}