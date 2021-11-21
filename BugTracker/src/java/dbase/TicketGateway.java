package dbase;

import dto.TicketDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "ticketGateway")
@RequestScoped
public class TicketGateway extends DatabaseManager
{
    public boolean insertTicket(String title,String description,String priority,String status,String type,String createdDateTime,
            String updatedDateTime,int projectId,int assignedDevId,int submitterId)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement(
                            "INSERT INTO TICKET_LOGS (title,description,priority,status,ticket_type,created_datetime,updated_datetime,project_id,assigned_dev_id,submitter_id)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3, priority);
            stmt.setString(4, status);
            stmt.setString(5, type);
            stmt.setString(6, createdDateTime);
            stmt.setString(7, updatedDateTime);
            stmt.setInt(8, projectId);
            stmt.setInt(9, assignedDevId);
            stmt.setInt(10, submitterId);

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
    public ArrayList<TicketDTO> getAllTickets(int projectId)
    {
        ArrayList<TicketDTO> tickets = new ArrayList<>();
        
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Tickets WHERE PROJECT_ID=? ORDER BY Ticket_ID");
            
            stmt.setInt(1, projectId);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                tickets.add(new TicketDTO(rs.getInt("TICKET_ID"), rs.getString("TITLE"),rs.getString("DESCRIPTION"),
                        rs.getString("PRIORITY"),rs.getString("STATUS"),rs.getString("TICKET_TYPE"),rs.getString("CREATED_DATETIME"),
                        rs.getString("UPDATED_DATETIME"),rs.getInt("PROJECT_ID"),rs.getInt("ASSIGNED_DEV_ID"),rs.getInt("SUBMITTER_ID")));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return new ArrayList<TicketDTO>();
        }
        
        return tickets;
    }
    public TicketDTO getTicket(int ticketId)
    {
        TicketDTO dto = null;
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Tickets " + "WHERE ticket_id = ?");

            stmt.setInt(1, ticketId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                dto = new TicketDTO(rs.getInt("TICKET_ID"), rs.getString("TITLE"),rs.getString("DESCRIPTION"),
                        rs.getString("PRIORITY"),rs.getString("STATUS"),rs.getString("TICKET_TYPE"),rs.getString("CREATED_DATETIME"),
                        rs.getString("UPDATED_DATETIME"),rs.getInt("PROJECT_ID"),rs.getInt("ASSIGNED_DEV_ID"),rs.getInt("SUBMITTER_ID"));
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
    public boolean changeTicketParameter(int ticketId,String parameter,String value)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt
                    = con.prepareStatement(
                            "UPDATE TICKETS SET ?=? WHERE TICKET_ID=?");

            stmt.setString(1, parameter);
            stmt.setString(2, value);
            stmt.setInt(3, ticketId);

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
