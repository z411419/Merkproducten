package be.oak3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/merkproducten?useSSL=false";
    private static final String USERNAME = "tom";
    private static final String PASSWORD = "12354$12354";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


}
