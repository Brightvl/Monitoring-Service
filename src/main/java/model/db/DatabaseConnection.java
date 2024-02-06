package model.db;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class DatabaseConnection {
//    //docker run -d --name Monitoring-service -p 5432:5432 -e POSTGRES_PASSWORD=password postgres:latest
//    private static String url = "jdbc:postgresql://localhost:5432/db_monitoring";
//    private static String user = "postgres";
//    private static String password = "password";

    public static Connection getConnection() {
        try (FileInputStream input = new FileInputStream("src/main/resources/db/liquibase/liquibase.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String jdbcUrl = properties.getProperty("url");
            String user = properties.getProperty("username");
            String password = properties.getProperty("password");

            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getData() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM Person";

            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("person_id"); // Пример, где "id" - название колонки
                    String username = resultSet.getString("name");
                    String password = resultSet.getString("password");

                    System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getConnection();
    }

    public static void show() {

    }
}
