package facade;

import dbase.AssignedStaffGateway;
import dbase.AttachmentGateway;
import dbase.CommentGateway;
import dbase.ProjectGateway;
import dbase.TicketGateway;
import dbase.TicketLogGateway;
import dbase.UserGateway;
import dto.AssignedStaffDTO;
import dto.AttachmentDTO;
import dto.CommentDTO;
import dto.ProjectDTO;
import dto.TicketDTO;
import dto.TicketLogDTO;
import dto.UserDTO;
import java.util.ArrayList;


public class TableFacade
{
    private UserGateway userGateway = new UserGateway();
    private TicketLogGateway ticketLogGateway = new TicketLogGateway();
    private TicketGateway ticketGateway = new TicketGateway();
    private ProjectGateway projectGateway = new ProjectGateway();
    private CommentGateway commentGateway = new CommentGateway();
    private AttachmentGateway attachmentGateway = new AttachmentGateway();
    private AssignedStaffGateway assignedStaffGateway = new AssignedStaffGateway();
    
    // User
    public boolean addUser(String name,String email,String password)
    {
        UserDTO u = userGateway.getUser(email);
        
        if (u == null)
        {
            userGateway.insertUser(name,email,password);
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<UserDTO> getAllUsers()
    {
        return userGateway.getAllUsers();
    }
    public UserDTO getUser(String email)
    {
        return userGateway.getUser(email);
    }
    public boolean changeUserParameter(String email,String parameter,String value)
    {
        UserDTO u = userGateway.getUser(email);
        
        if (u != null)
        {
            userGateway.changeUserParameter(email,parameter,value);
            return true;
        }
        else{
            return false;
        }
    }
    // Ticket Log
    public boolean addTicketLog(String property,String oldValue,String newValue,String changedDateTime,int projectId,int devId)
    {
        return ticketLogGateway.insertTicketLog(property,oldValue,newValue,changedDateTime,projectId,devId);
    }
    public ArrayList<TicketLogDTO> getAllTicketLogs(int projectId)
    {
        return ticketLogGateway.getAllTicketLogs(projectId);
    }
    public TicketLogDTO getTicketLog(int ticketLogId)
    {
        return ticketLogGateway.getTicketLog(ticketLogId);
    }
    
    // Ticket
    public boolean addTicket(String title,String description,String priority,String status,String type,String createdDateTime,
            String updatedDateTime,int projectId,int assignedDevId,int submitterId)
    {
        return ticketGateway.insertTicket(title,description,priority,status,type,createdDateTime,
            updatedDateTime,projectId,assignedDevId,submitterId);
    }
    public ArrayList<TicketDTO> getAllTickets(int projectId)
    {
        return ticketGateway.getAllTickets(projectId);
    }
    public TicketDTO getTicket(int ticketId)
    {
        return ticketGateway.getTicket(ticketId);
    }
    public boolean changeTicketParameter(int ticketId,String parameter,String value)
    {
        TicketDTO t = ticketGateway.getTicket(ticketId);
        
        if (t != null)
        {
            ticketGateway.changeTicketParameter(ticketId,parameter,value);
            return true;
        }
        else{
            return false;
        }
    }
    
    // Project
    public boolean addProject(String name,String description)
    {
        return projectGateway.insertProject(name,description);
    }
    public ArrayList<ProjectDTO> getAllProjects()
    {
        return projectGateway.getAllProjects();
    }
    public ProjectDTO getProject(int projectId)
    {
        return projectGateway.getProject(projectId);
    }
    public boolean changeProjectParameter(int projectId,String parameter,String value)
    {
        ProjectDTO p = projectGateway.getProject(projectId);
        
        if (p != null)
        {
            projectGateway.changeProjectParameter(projectId,parameter,value);
            return true;
        }
        else{
            return false;
        }
    }
    
    // Comment
    public boolean addComment(String name,String createdDateTime,int projectId,int commenterId)
    {
        return commentGateway.insertComment(name,createdDateTime,projectId,commenterId);
    }
    public ArrayList<CommentDTO> getAllComments(int projectId)
    {
        return commentGateway.getAllComments(projectId);
    }
    public CommentDTO getComment(int commentId)
    {
        return commentGateway.getComment(commentId);
    }
    
    // Attachment
    public boolean addAttachment(String name,String notes,String uploadedDateTime,int projectId,int userId)
    {
        return attachmentGateway.insertAttachment(name,notes,uploadedDateTime,projectId,userId);
    }
    public ArrayList<AttachmentDTO> getAllAttachments(int projectId)
    {
        return attachmentGateway.getAllAttachments(projectId);
    }
    public AttachmentDTO getAttachment(int attachmentId)
    {
        return attachmentGateway.getAttachment(attachmentId);
    }
    
    // Assigned Staff
    public boolean addAssignedStaff(int projectId,int userId)
    {
        return assignedStaffGateway.insertAssignedStaff(projectId,userId);
    }
    public ArrayList<AssignedStaffDTO> getAllAssignedStaff(int projectId)
    {
        return assignedStaffGateway.getAllAssignedStaff(projectId);
    }
}
