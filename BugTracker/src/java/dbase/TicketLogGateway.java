package dbase;

import dto.TicketLogDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "ticketLogGateway")
@RequestScoped
public class TicketLogGateway extends DatabaseManager
{
    public boolean insertTicketLog(String property,String oldValue,String newValue,String changedDateTime,int projectId,int devId)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement(
                            "INSERT INTO TICKET_LOGS (property,old_value,new_value,changed_datetime,project_id,dev_id)"
                            + "VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setString(1, property);
            stmt.setString(2, oldValue);
            stmt.setString(3, newValue);
            stmt.setString(4, changedDateTime);
            stmt.setInt(5, projectId);
            stmt.setInt(6, devId);

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
    public ArrayList<TicketLogDTO> getAllTicketLogs(int projectId)
    {
        ArrayList<TicketLogDTO> ticketLogs = new ArrayList<>();
        
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Ticket_Logs WHERE PROJECT_ID=? ORDER BY Ticket_Log_ID");
            
            stmt.setInt(1, projectId);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                ticketLogs.add(new TicketLogDTO(rs.getInt("TICKET_LOG_ID"), rs.getString("PROPERTY"),rs.getString("OLD_VALUE"),rs.getString("NEW_VALUE"),rs.getString("CHANGED_DATETIME"),rs.getInt("PROJECT_ID"),rs.getInt("DEV_ID")));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return new ArrayList<TicketLogDTO>();
        }
        
        return ticketLogs;
    }
    public TicketLogDTO getTicketLog(int ticketLogId)
    {
        TicketLogDTO dto = null;
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Ticket_Logs " + "WHERE ticket_log_id = ?");

            stmt.setInt(1, ticketLogId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                dto = new TicketLogDTO(rs.getInt("TICKET_LOG_ID"), rs.getString("PROPERTY"),rs.getString("OLD_VALUE"),rs.getString("NEW_VALUE"),rs.getString("CHANGED_DATETIME"),rs.getInt("PROJECT_ID"),rs.getInt("DEV_ID"));
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
