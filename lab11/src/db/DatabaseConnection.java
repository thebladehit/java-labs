package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    public static Connection getConnection() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/resources/db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
