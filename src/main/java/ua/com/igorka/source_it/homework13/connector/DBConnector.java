package ua.com.igorka.source_it.homework13.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by igor on 15.11.14
 * Project name: FirstJSP
 */
public class DBConnector {

    private static final DBConnector INSTANCE = new DBConnector();

    private DBConnector() {

    }

    public static DBConnector getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ResourceBundle r = ResourceBundle.getBundle("db");

        String connectionString = new StringBuilder("")
                .append("jdbc:" + r.getString("db.driver") + "://")
                .append(r.getString("db.host"))
                .append(":")
                .append(r.getString("db.port"))
                .append("/")
                .append(r.getString("db.name"))
                .toString();
        return DriverManager.getConnection(connectionString, r.getString("db.user"),
                r.getString("db.password"));

    }

}
