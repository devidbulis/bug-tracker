package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="assignedStaff")
public class AssignedStaffDTO implements Serializable
{
    private int projectId;
    private int userId;


    public AssignedStaffDTO(int projectId,int userId)
    {
        this.projectId = projectId;
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getUserId() {
        return userId;
    }
    
}
