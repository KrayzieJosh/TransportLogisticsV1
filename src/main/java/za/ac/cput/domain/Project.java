package za.ac.cput.domain;

import java.util.List;

public class Project {
    private String projectId;
    private String projectName;
    private String projectStatus;
    private List<ProjectManager> projectManagers;
    private List<SiteManager> siteManagers;

    private Project(ProjectBuilder projectBuilder){
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.projectManagers=projectManagers;
        this.siteManagers=siteManagers;


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

    public List<ProjectManager> getProjectManagers() {
        return projectManagers;
    }

    public List<SiteManager> getSiteManagers() {
        return siteManagers;
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
        private List<ProjectManager> projectManagers;
        private List<SiteManager> siteManagers;

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

        public ProjectBuilder setProjectManagers(List<ProjectManager> projectManagers) {
            this.projectManagers = projectManagers;
            return this;
        }

        public ProjectBuilder setSiteManagers(List<SiteManager> siteManagers) {
            this.siteManagers = siteManagers;
            return this;
        }
        public Project.ProjectBuilder copyManagers(Project siteAndProjectManagers){
            this.projectId=siteAndProjectManagers.projectId;
            this.projectName=siteAndProjectManagers.projectName;
            this.projectStatus=siteAndProjectManagers.projectStatus;
            this.projectManagers=siteAndProjectManagers.projectManagers;
            this.siteManagers=siteAndProjectManagers.siteManagers;

            return this;
        }
        public Project build(){
            return new Project(this);

        }
    }

}
