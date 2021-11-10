package dbase;

import dto.CommentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "commentGateway")
@RequestScoped
public class CommentGateway extends DatabaseManager
{
    public boolean insertComment(String name,String createdDateTime,int projectId,int commenterId)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement(
                            "INSERT INTO COMMENTS (text,created_datetime,project_id,commenter_id)"
                            + "VALUES (?, ?, ?, ?)");

            stmt.setString(1, name);
            stmt.setString(2, createdDateTime);
            stmt.setInt(3, projectId);
            stmt.setInt(4, commenterId);

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
    public ArrayList<CommentDTO> getAllComments(int projectId)
    {
        ArrayList<CommentDTO> comments = new ArrayList<>();
        
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM COMMENTS WHERE PROJECT_ID=? ORDER BY COMMENT_ID");
            
            stmt.setInt(1, projectId);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                comments.add(new CommentDTO(rs.getInt("COMMENT_ID"), rs.getString("TEXT"),rs.getString("CREATED_DATETIME"),rs.getInt("PROJECT_ID"),rs.getInt("COMMENTER_ID")));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return new ArrayList<CommentDTO>();
        }
        
        return comments;
    }
    public CommentDTO getComment(int commentId)
    {
        CommentDTO dto = null;
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM COMMENTS " + "WHERE COMMENT_ID = ?");

            stmt.setInt(1, commentId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                dto = new CommentDTO(rs.getInt("COMMENT_ID"), rs.getString("TEXT"),rs.getString("CREATED_DATETIME"),rs.getInt("PROJECT_ID"),rs.getInt("COMMENTER_ID"));
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
