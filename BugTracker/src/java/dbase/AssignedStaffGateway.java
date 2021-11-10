package dbase;

import dto.AssignedStaffDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "assignedStaffGateway")
@RequestScoped
public class AssignedStaffGateway extends DatabaseManager
{
    public boolean insertAssignedStaff(int projectId,int userId)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement(
                            "INSERT INTO ASSIGNED_STAFF (project_id,user_id)"
                            + "VALUES (?, ?)");

            stmt.setInt(1, projectId);
            stmt.setInt(2, userId);

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
    public ArrayList<AssignedStaffDTO> getAllAssignedStaff(int projectId)
    {
        ArrayList<AssignedStaffDTO> assignedStaff = new ArrayList<>();
        
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ASSIGNED_STAFF WHERE PROJECT_ID=?");
            
            stmt.setInt(1, projectId);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                assignedStaff.add(new AssignedStaffDTO(rs.getInt("PROJECT_ID"), rs.getInt("USER_ID")));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return new ArrayList<AssignedStaffDTO>();
        }
        
        return assignedStaff;
    }
}
