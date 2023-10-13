package com.oracledbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:oracle:thin:@yourDB_high";
    private static final String PASSWORD = "YOUR_DATABASE_PASSWORD";
    private static final String USER = "YOUR_DATABASE_USERNAME";

    public static Connection obtenerConexion() throws Exception {
        
        System.setProperty("oracle.net.tns_admin", "YOUR_WALLET_PATH");
        
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw e;
        }
    }
}
