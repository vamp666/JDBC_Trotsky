package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mytestdb";
    private static final String USERNAME = "trotsky";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        Driver driver;

        try   {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            //System.out.println("Драйвен зарегистрирован");
        }
        catch (SQLException e1) {
            System.out.println("Драйвер не зарегистрирован");
            throw e1;
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed())
                System.out.println("");
        } catch (SQLException ex) {
            System.err.println("Соединение не установлено");
            ex.printStackTrace();
        }
        return connection;
    }

}
