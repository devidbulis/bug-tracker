package dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseManager {
    
    public Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost/bug_tracker_db?user=root");
        }
        catch (SQLException e)
        {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
