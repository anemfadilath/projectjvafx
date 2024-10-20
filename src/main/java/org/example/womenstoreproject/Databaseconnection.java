package org.example.womenstoreproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Databaseconnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/storeproject";
        String user = "root";
        String password = "Amro7656@";
        return DriverManager.getConnection(url, user, password);



    }
}
