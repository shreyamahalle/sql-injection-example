package com.shreya.spring.repository;

import com.shreya.spring.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class LoginRepository {

    @Autowired
    private ConnectionService connectionService;

    public boolean insecureLogin(String query) throws SQLException {
        //Unsafe query which uses string concatenation
        try(Connection connection = connectionService.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                //Login Successful if match is found
                return true;
            }
        }catch (Exception e){
            return  false;
        }
        return false;
    }

    public boolean secureLogin(String query , String username, String password){
        try (Connection connection = connectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
             preparedStatement.setString(1,username);
             preparedStatement.setString(2,password);
             ResultSet resultSet = preparedStatement.executeQuery();

             if (resultSet.next()){
                 //Login successful if match is found
                 return true;
             }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
