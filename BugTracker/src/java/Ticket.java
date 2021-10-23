public class Ticket {
    
    private int num;
    private String name;
    private String description;
    private Project project;
    private Developer assignedDev;
    private String priority = "None";
    private String status = "New";
    private String type;
    private Long createdDateTime;
    private Long updatedDateTime;
    
    public Ticket(int num, String name, String description, Project project, Developer assignedDev, String type){
        this.num = num;
        this.name = name;
        this.description = description;
        this.project = project;
        this.assignedDev = assignedDev;
        this.type = type;
        this.createdDateTime = System.currentTimeMillis();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Developer getAssignedDev() {
        return assignedDev;
    }

    public void setAssignedDev(Developer assignedDev) {
        this.assignedDev = assignedDev;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Long getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Long updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
