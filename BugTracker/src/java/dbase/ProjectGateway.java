package dbase;

import dto.ProjectDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "projectGateway")
@RequestScoped
public class ProjectGateway extends DatabaseManager
{
    public boolean insertProject(String name,String description)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement(
                            "INSERT INTO PROJECTS (name,description)"
                            + "VALUES (?, ?)");

            stmt.setString(1, name);
            stmt.setString(2, description);

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
    public ArrayList<ProjectDTO> getAllProjects()
    {
        ArrayList<ProjectDTO> projects = new ArrayList<>();
        
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PROJECTS ORDER BY PROJECT_ID");
            
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                projects.add(new ProjectDTO(rs.getInt("PROJECT_ID"), rs.getString("NAME"),rs.getString("DESCRIPTION")));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return new ArrayList<ProjectDTO>();
        }
        
        return projects;
    }
    public ProjectDTO getProject(int projectId)
    {
        ProjectDTO dto = null;
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM PROJECTS " + "WHERE PROJECT_ID = ?");

            stmt.setInt(1, projectId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                dto = new ProjectDTO(rs.getInt("PROJECT_ID"), rs.getString("NAME"),rs.getString("DESCRIPTION"));
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
    public boolean changeProjectParameter(int projectId,String parameter,String value)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt
                    = con.prepareStatement(
                            "UPDATE PROJECTS SET ?=? WHERE PROJECT_ID=?");

            stmt.setString(1, parameter);
            stmt.setString(2, value);
            stmt.setInt(3, projectId);

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
}
