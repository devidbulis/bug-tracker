package dbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            PreparedStatement stmt
                    = con.prepareStatement(
                            "SELECT * FROM Users "
                            + "WHERE email = ?");

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
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "User could not be registered", e);
            return false;
        }
    }
}
