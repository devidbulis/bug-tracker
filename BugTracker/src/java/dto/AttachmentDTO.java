package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="attachment")
public class AttachmentDTO implements Serializable
{
    private int id;
    private String name;
    private String notes;
    private long uploadedDateTime;
    private int projectId;
    private int userId;

    public AttachmentDTO(int id, String name,String notes,long uploadedDateTime,int projectId,int userId)
    {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.uploadedDateTime = uploadedDateTime;
        this.projectId = projectId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public long getUploadedDateTime() {
        return uploadedDateTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getUserId() {
        return userId;
    }
    
}
