package Utils;

import java.sql.*;

public class ConnectionManager
{
    // Const string for DataBase connection...
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static Statement statement;

    // Connection manager
    public void GetDBConnect()
    {
        String connectString = "jdbc:mysql://localhost:3306/adanosdb";

        try
        {
            statement = DriverManager.getConnection(connectString, USERNAME, PASSWORD).createStatement();
        }
        catch (SQLException err) { err.printStackTrace(); }
    }
}
