package ua.com.igorka.source_it.homework13;

import org.junit.Test;
import ua.com.igorka.source_it.homework13.connector.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.fail;

/**
 * Created by igor on 15.11.14
 * Project name: FirstJSP
 */
public class DBConnectorTest {

    @Test
    public void testConnection() {
        try {
            Connection connection = DBConnector.getInstance().getConnection();
            connection.close();
        } catch (SQLException e) {
            fail();
        }
    }
}
