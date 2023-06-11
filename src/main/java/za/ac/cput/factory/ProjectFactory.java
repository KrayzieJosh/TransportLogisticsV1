package za.ac.cput.factory;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.util.Helper;

import java.util.List;

public class ProjectFactory {
    public static Project createProjectAndSiteManagers(String projectId, String projectName, String projectStatus,
                                                       List<ProjectManager>projectManagers, List<SiteManager>siteManagers){
        projectId= Helper.generateID();
        if(Helper.isNullOrEmpty(projectId)||Helper.isNullOrEmpty(projectName)||Helper.isNullOrEmpty(projectStatus)
            ||Helper.isNullOrEmpty(String.valueOf(projectManagers))||Helper.isNullOrEmpty(String.valueOf(siteManagers))){

            return null;
        }

return new Project.ProjectBuilder().setProjectId(projectId).setProjectName(projectName).setProjectStatus(projectStatus)
        .setProjectManagers(projectManagers).setSiteManagers(siteManagers).build();
    }
}
