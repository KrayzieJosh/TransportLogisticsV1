package za.ac.cput.domain;

public class Project {
    private String projectId;
    private String projectName;
    private String projectStatus;

    public Project(String projectId, String projectName, String projectStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }
}
