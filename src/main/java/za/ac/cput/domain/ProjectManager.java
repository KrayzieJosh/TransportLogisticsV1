package za.ac.cput.domain;

import java.util.List;

public class ProjectManager{
    private String userId;
    private String userPosition;
    private List<Project> userProjects;

    private ProjectManager(ProjectManagerBuilder builder){
        this.userId=builder.userId;
        this.userPosition=builder.userPosition;
        this.userProjects=builder.userProjects;


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
        return "ProjectManager{" +
                "userId='" + userId + '\'' +
                ", userPosition='" + userPosition + '\'' +
                ", userProjects=" + userProjects +
                '}';
    }

    public static class ProjectManagerBuilder{
        private String userId;
        private String userPosition;
        private List<Project> userProjects;

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
        public ProjectManagerBuilder copy(ProjectManager projectManager){
            this.userId=projectManager.userId;
            this.userPosition=projectManager.userPosition;
            this.userProjects=projectManager.userProjects;

            return this;
        }
    public ProjectManager build(){
        return new ProjectManager(this);

    }
}

}
