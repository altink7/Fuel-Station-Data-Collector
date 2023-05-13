package at.disys.db;

import java.sql.Connection;

public class DatabaseConnector {
    private Connection postgresConnection;
    private final String username = "postgres";
    private final String password = "postgres";

    /**
     * Connects to the database POSTGRES
     */
    public void connect(ConnectionURL url) {
        try {
            Class.forName("org.postgresql.Driver");
            postgresConnection = java.sql.DriverManager.getConnection(url.getUrl(), username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Disconnects from the database POSTGRES
     */
    public void disconnect(ConnectionURL url) {
        try {
            postgresConnection = java.sql.DriverManager.getConnection(url.getUrl(), username, password);
            postgresConnection.close();
            System.out.println("Disconnected from the PostgreSQL server "+url.getUrl()+" successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
