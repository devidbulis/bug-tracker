package dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseManager {
    
    public Connection getConnection()
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            return DriverManager.getConnection("jdbc:derby://localhost:1527/bugTrackerDB", "bug123", "bug123");
        }
        catch (SQLException e)
        {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
