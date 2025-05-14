package com.shreya.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionService {

    @Value("${application.mysql.connection-url}")
    private String jdbcUrl;

    @Value("${application.mysql.username}")
    private String username;

    @Value("${application.mysql.password")
    private String password;

    public Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection to the database");

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return connection;
    }
}
