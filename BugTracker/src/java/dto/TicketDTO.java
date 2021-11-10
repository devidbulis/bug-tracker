package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="ticket")
public class TicketDTO implements Serializable
{
    private int id;
    private String title;
    private String description;
    private String priority;
    private String status;
    private String type;
    private String createdDateTime;
    private String updatedDateTime;
    private int projectId;
    private int assignedDevId;
    private int submitterId;

    public TicketDTO(int id,String title,String description,String priority,String status,String type,String createdDateTime,
            String updatedDateTime,int projectId,int assignedDevId,int submitterId)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.type = type;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
        this.projectId = projectId;
        this.assignedDevId = assignedDevId;
        this.submitterId = submitterId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public String getUpdatedDateTime() {
        return updatedDateTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getAssignedDevId() {
        return assignedDevId;
    }

    public int getSubmitterId() {
        return submitterId;
    }
    
}
