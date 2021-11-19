package dbase;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "userGateway")
@RequestScoped
public class UserGateway extends DatabaseManager
{
    public boolean credentialsAreOK(String email, String hashedPassword)
    {
        boolean credentialsOK = false;

        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users " + "WHERE email = ?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                String pwd = rs.getString("password");
                
                if (pwd.equals(hashedPassword))
                {
                    credentialsOK = true;
                }
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch (Exception e)
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "User credentials could not be checked", e);
        }

        return credentialsOK;
    }

    public boolean insertUser(String name, String email, String hashedPassword)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt
                    = con.prepareStatement(
                            "INSERT INTO Users (name, email, role, password) "
                            + "VALUES (?, ?, ?, ?)");

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, "None");
            stmt.setString(4, hashedPassword);

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
    public ArrayList<UserDTO> getAllUsers()
    {
        ArrayList<UserDTO> users = new ArrayList<>();
        
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users ORDER BY USER_ID");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                users.add(new UserDTO(rs.getInt("USER_ID"), rs.getString("NAME"),rs.getString("EMAIL"),rs.getString("ROLE"),rs.getString("PASSWORD")));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return new ArrayList<UserDTO>();
        }
        
        return users;
    }
    public UserDTO getUser(String email)
    {
        UserDTO user = null;
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users " + "WHERE email = ?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                user = new UserDTO(rs.getInt("USER_ID"), rs.getString("NAME"),rs.getString("EMAIL"),rs.getString("ROLE"),rs.getString("PASSWORD"));
            }
            
            rs.close();
            stmt.close();
            con.close();
            return user;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return user;
        }
    }
    public boolean ChangeUserRole(String email,String role)
    {
        try
        {
            Connection con = getConnection();

            PreparedStatement stmt
                    = con.prepareStatement(
                            "UPDATE Users SET ROLE=? WHERE EMAIL=?");

            stmt.setString(1, role);
            stmt.setString(2, email);

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

    public void changeUserRole(String email, String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
