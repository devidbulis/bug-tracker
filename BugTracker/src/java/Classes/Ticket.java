package Classes;


import Classes.TicketLog;
import java.util.ArrayList;

public class Ticket {
    
    private int id;
    private String title;
    private String description;
    private Project project;
    private Submitter submitter;
    private Developer assignedDev;
    private String priority = "None";
    private String status = "New";
    private String type;
    private Long createdDateTime;
    private Long updatedDateTime;
    private ArrayList<Attachment> attachments;
    private ArrayList<Comment> comments;
    private ArrayList<TicketLog> log;
    
    public Ticket(int id, String title, String description, Project project, Submitter submitter, Developer assignedDev, String type){
        this.id = id;
        this.title = title;
        this.description = description;
        this.project = project;
        this.submitter = submitter;
        this.assignedDev = assignedDev;
        this.type = type;
        this.createdDateTime = System.currentTimeMillis();
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
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

    public Submitter getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Submitter submitter) {
        this.submitter = submitter;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<TicketLog> getLog() {
        return log;
    }

    public void setLog(ArrayList<TicketLog> log) {
        this.log = log;
    }
}
