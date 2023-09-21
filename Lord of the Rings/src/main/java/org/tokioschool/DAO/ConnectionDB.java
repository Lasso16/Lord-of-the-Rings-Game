package org.tokioschool.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connection db.
 */
public class ConnectionDB {

    private Connection connection;
    private static final String URL = "jdbc:sqlite:characters.db";

    /**
     * Connect with database.
     *
     * @throws SQLException the sql exception
     */
    public void connect() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(URL);
    }

    /**
     * Closes the connection.
     *
     * @throws SQLException the sql exception
     */
    public void close() throws SQLException {
        connection.close();
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
}