package org.example;

public class Main {
    public static void main(String[] args) {
        PostgreSQLConnection postgreSQLConnection = new PostgreSQLConnection();
        postgreSQLConnection.connect();
    }
}