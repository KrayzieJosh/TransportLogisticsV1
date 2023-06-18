package za.ac.cput.factory;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.util.Helper;

import java.io.Serializable;
import java.util.List;

public class ProjectFactory implements Serializable {

    public static Project createProject(String projectId, String projectName, String projectStatus){
        projectId= Helper.generateID();
        if(Helper.isNullOrEmpty(projectId)||Helper.isNullOrEmpty(projectName)||Helper.isNullOrEmpty(projectStatus)){

            return null;
        }

return new Project.ProjectBuilder().setProjectId(projectId).setProjectName(projectName).setProjectStatus(projectStatus).build();
    }
}
