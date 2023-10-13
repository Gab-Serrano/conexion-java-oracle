package com.oracledbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:oracle:thin:@testdb_high";
    private static final String PASSWORD = "Iwtltpuyam123#";
    private static final String USER = "admin";

    public static Connection obtenerConexion() throws Exception {
        
        System.setProperty("oracle.net.tns_admin", "D:\\Usuarios\\Gabriel Serrano\\OneDrive\\Escritorio\\test-oracle\\wallet");
        
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw e;
        }
    }
}
