package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PostgreSQLConnection postgreSQLConnection = new PostgreSQLConnection();
        postgreSQLConnection.connect();
        postgreSQLConnection.findEmployeeByName("Jane");
    }
}