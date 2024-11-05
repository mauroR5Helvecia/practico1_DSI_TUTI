package com.diseniosistemas.TP1_DSI.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/tp_dsi_db";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
