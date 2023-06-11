package za.ac.cput.domain;

import java.util.List;

public class Project {
    private String projectId;
    private String projectName;
    private String projectStatus;


    private Project(ProjectBuilder projectBuilder){
        this.projectId = projectBuilder.projectId;
        this.projectName = projectBuilder.projectName;
        this.projectStatus = projectBuilder.projectStatus;

    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }
    public static class ProjectBuilder{
        private String projectId;
        private String projectName;
        private String projectStatus;

        public ProjectBuilder setProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public ProjectBuilder setProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public ProjectBuilder setProjectStatus(String projectStatus) {
            this.projectStatus = projectStatus;
            return this;
        }

        public Project.ProjectBuilder copy(Project project){
            this.projectId=project.projectId;
            this.projectName=project.projectName;
            this.projectStatus=project.projectStatus;

            return this;
        }
        public Project build(){
            return new Project(this);

        }
    }

}
