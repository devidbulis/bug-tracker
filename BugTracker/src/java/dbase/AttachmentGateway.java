package dbase;

import dto.AttachmentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "attachmentGateway")
@RequestScoped
public class AttachmentGateway extends DatabaseManager
{
    public boolean insertAttachment(String name,String notes,String uploadedDateTime,int projectId,int userId)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement(
                            "INSERT INTO ATTACHMENTS (file_name,notes,uploaded_datetime,project_id,user_id)"
                            + "VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setString(1, name);
            stmt.setString(2, notes);
            stmt.setString(3, uploadedDateTime);
            stmt.setInt(4, projectId);
            stmt.setInt(5, userId);

            int rows = stmt.executeUpdate();

            stmt.close();
            con.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<AttachmentDTO> getAllAttachments(int projectId)
    {
        ArrayList<AttachmentDTO> attachments = new ArrayList<>();
        
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ATTACHMENTS WHERE PROJECT_ID=? ORDER BY ATTACHMENT_ID");
            
            stmt.setInt(1, projectId);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                attachments.add(new AttachmentDTO(rs.getInt("ATTACHMENT_ID"), rs.getString("FILE_NAME"),rs.getString("NOTES"),rs.getString("UPLOADED_DATETIME"),rs.getInt("PROJECT_ID"),rs.getInt("USER_ID")));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return new ArrayList<AttachmentDTO>();
        }
        
        return attachments;
    }
    public AttachmentDTO getAttachment(int attachmentId)
    {
        AttachmentDTO dto = null;
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM ATTACHMENTS " + "WHERE ATTACHMENT_ID = ?");

            stmt.setInt(1, attachmentId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                dto = new AttachmentDTO(rs.getInt("ATTACHMENT_ID"), rs.getString("FILE_NAME"),rs.getString("NOTES"),rs.getString("UPLOADED_DATETIME"),rs.getInt("PROJECT_ID"),rs.getInt("USER_ID"));
            }
            
            rs.close();
            stmt.close();
            con.close();
            return dto;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return dto;
        }
    }
}
