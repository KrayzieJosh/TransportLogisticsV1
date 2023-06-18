package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.service.ProjectManagerService;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("projectmanager")
public class ProjectManagerController {
    @Autowired
    private ProjectManagerService projectManagerService;
    @PostMapping("/create")
    public ProjectManager create(@RequestBody ProjectManager projectManager){

        ProjectManager newProjectManager= ProjectManagerFactory.createProjectManager(projectManager.getUserId(),
                projectManager.getUserPosition(),projectManager.getUserProjects(),projectManager.getSiteManager());
        return projectManagerService.create(newProjectManager);

    }
    @GetMapping("/read/{id}")
    public ProjectManager read(@PathVariable String id){
        return projectManagerService.read(id);

    }
    @PostMapping("/update")
    public ProjectManager update(@RequestBody ProjectManager projectManager){
        return projectManagerService.update(projectManager);

    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return projectManagerService.delete(id);

    }
    @GetMapping("/getall")
    public Set<ProjectManager> getAll(){
        return projectManagerService.getAll();

    }


}
