package org.example;

import java.sql.*;

public class PostgreSQLConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/employees_db";
    private static final String username = "postgres";
    private static final String password = "19732846Gs56";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Подключение к базе данных выполнено успешно.");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        }
        return conn;
    }
    public void findEmployeeByName(String firstName) throws SQLException {
        String query = "SELECT * FROM employees WHERE first_name = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: "
                        + rs.getString("first_name") + " " + rs.getString("last_name")
                        + ", Department: " + rs.getString("department")
                        + ", Salary: " + rs.getBigDecimal("salary"));
            }
        }
    }
    public  void selectEmloyeeByDepartment(String department) throws SQLException {
        String query = "SELECT * FROM employees WHERE department = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
                 preparedStatement.setString(1, department);
                 ResultSet rs = preparedStatement.executeQuery();
                 while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name")+" "+rs.getBigDecimal("salary"));
                 }
        }
        }
}
