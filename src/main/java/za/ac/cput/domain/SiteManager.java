package za.ac.cput.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.List;
@EntityScan

public class SiteManager implements Serializable {
    private String userId;
    private String userPosition;
    private List<Project> userProjects;


    private SiteManager(SiteManagerBuilder builder){
        this.userId=builder.userId;
        this.userPosition=builder.userPosition;
        this.userProjects=builder.userProjects;


    }

    public SiteManager() {
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

    @Override
    public String toString() {
        return "SiteManager{" +
                "userId='" + userId + '\'' +
                ", userPosition='" + userPosition + '\'' +
                ", userProjects=" + userProjects +
                '}';
    }

    public static class SiteManagerBuilder{
        private String userId;
        private String userPosition;
        private List<Project> userProjects;

        public SiteManagerBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public SiteManagerBuilder setUserPosition(String userPosition) {
            this.userPosition = userPosition;
            return this;

        }

        public SiteManagerBuilder setUserProjects(List<Project> userProjects) {
            this.userProjects = userProjects;
            return this;

        }
        public SiteManager.SiteManagerBuilder copy(SiteManager siteManager){
            this.userId=siteManager.userId;
            this.userPosition=siteManager.userPosition;
            this.userProjects=siteManager.userProjects;

            return this;
        }
        public SiteManager build(){
            return new SiteManager(this);

        }
}
}
