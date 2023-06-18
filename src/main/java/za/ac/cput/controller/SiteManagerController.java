package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.service.SiteManagerService;

import java.util.Set;

@RestController
@RequestMapping("/sitemanager")
public class SiteManagerController {
    @Autowired
    private SiteManagerService siteManagerService;
    @PostMapping("/create")
    public SiteManager create(@RequestBody SiteManager siteManager){

        SiteManager newSiteManager= SiteManagerFactory.createSiteManager(siteManager.getUserId(),
                siteManager.getUserPosition(),siteManager.getUserProjects());
        return siteManagerService.create(newSiteManager);

    }
    @GetMapping("/read/{id}")
    public SiteManager read(@PathVariable String id){
        return siteManagerService.read(id);

    }
    @PostMapping("/update")
    public SiteManager update(@RequestBody SiteManager siteManager){
        return siteManagerService.update(siteManager);

    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return siteManagerService.delete(id);

    }
    @GetMapping("/getall")
    public Set<SiteManager> getAll(){
        return siteManagerService.getAll();

    }
}
