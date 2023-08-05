package sample._BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static final String DB_NAME = "jdbc:mysql://www.papademas.net:3307/510fp?autoReconnect=true&useSSL=false";
    public static final String USERNAME = "fp510";
    public static final String PASSWORD = "510";

    public static Connection connection = null;

    public static Connection getConnections(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(DB_NAME, USERNAME, PASSWORD
            );
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean checkConnections(){
        return connection != null;
    }

    public static void closeConnections(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
