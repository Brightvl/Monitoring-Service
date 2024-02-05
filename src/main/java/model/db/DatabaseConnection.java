package model.db;

import java.sql.*;


public class DatabaseConnection {
    //docker run -d --name Monitoring-service -p 5432:5432 -e POSTGRES_PASSWORD=password postgres:latest
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "password";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к БД " + e);
        }
    }
}
