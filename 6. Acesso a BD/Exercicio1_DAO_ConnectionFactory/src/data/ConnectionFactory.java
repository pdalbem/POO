package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import  java.sql.PreparedStatement;

public abstract class ConnectionFactory {
    private static Connection conn  = null;

    public  static Connection getConnection() throws SQLException {
        if (conn == null)
            conn = DriverManager.getConnection("jdbc:sqlite:empresa.db");
        return conn;
    }


    public static PreparedStatement createStatement(String sql) throws SQLException  {
        return getConnection().prepareStatement(sql);
    }

}
