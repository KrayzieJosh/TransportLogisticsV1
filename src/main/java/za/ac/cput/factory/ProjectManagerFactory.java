package za.ac.cput.factory;

import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.util.Helper;

import java.util.List;

public class ProjectManagerFactory {
    public static ProjectManager createProjectManager(String userId, String userPosition,
                                                      List<Project> userProjects, List<SiteManager>siteManagers) {
        userId = Helper.generateID();
        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(userPosition)
                || Helper.isNullOrEmpty(String.valueOf(userProjects))) {

            return null;
        }

        return new ProjectManager.ProjectManagerBuilder()
                .setUserId(userId)
                .setUserPosition(userPosition)
                .setUserProjects(userProjects).setSiteManager(siteManagers)
                .build();
    }

}
