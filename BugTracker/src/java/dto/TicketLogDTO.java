package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="ticketLog")
public class TicketLogDTO implements Serializable
{
    private int id;
    private String property;
    private String oldValue;
    private String newValue;
    private String changedDateTime;
    private int projectId;
    private int devId;

    public TicketLogDTO(int id, String property,String oldValue,String newValue,String changedDateTime,int projectId,int devId)
    {
        this.id = id;
        this.property = property;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changedDateTime = changedDateTime;
        this.projectId = projectId;
        this.devId = devId;
    }

    public int getId() {
        return id;
    }

    public String getProperty() {
        return property;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getChangedDateTime() {
        return changedDateTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getDevId() {
        return devId;
    }
    
}
