package za.ac.cput.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;
@EntityScan
public class ProjectManager implements Serializable {
    private String userId;
    private String userPosition;
    private List<Project> userProjects;
    private List<SiteManager> siteManager;


    private ProjectManager(ProjectManagerBuilder builder){
        this.userId=builder.userId;
        this.userPosition=builder.userPosition;
        this.userProjects=builder.userProjects;
        this.siteManager=builder.siteManager;



    }
    public String getUserId() {
        return userId;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public List<Project> getUserProjects() {
        return userProjects;
    }

    public List<SiteManager> getSiteManager() {
        return siteManager;
    }

    @Override
    public String toString() {
        return "ProjectManager{" +
                "userId='" + userId + '\'' +
                ", userPosition='" + userPosition + '\'' +
                ", userProjects=" + userProjects +
                ", siteManager=" + siteManager +
                '}';
    }

    public ProjectManager(String userId, String userPosition, List<Project> userProjects, List<SiteManager> siteManager) {
        this.userId = userId;
        this.userPosition = userPosition;
        this.userProjects = userProjects;
        this.siteManager = siteManager;
    }

    public ProjectManager() {
    }



    public static class ProjectManagerBuilder{
        private String userId;
        private String userPosition;
        private List<Project> userProjects;
        private List<SiteManager> siteManager;


        public ProjectManagerBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public ProjectManagerBuilder setUserPosition(String userPosition) {
        this.userPosition = userPosition;
        return this;

    }

    public ProjectManagerBuilder setUserProjects(List<Project> userProjects) {
        this.userProjects = userProjects;
        return this;

    }

        public ProjectManagerBuilder setSiteManager(List<SiteManager> siteManager) {
            this.siteManager = siteManager;
            return this;
        }

        public ProjectManagerBuilder copy(ProjectManager projectManager){
            this.userId=projectManager.userId;
            this.userPosition=projectManager.userPosition;
            this.userProjects=projectManager.userProjects;
            this.siteManager=projectManager.siteManager;

            return this;
        }
    public ProjectManager build(){
        return new ProjectManager(this);

    }
}

}
