package com.shopping.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    private static final Logger logger = Logger.getLogger(UserDAO.class.getName());

    public User getDetails(String username) {
        User user = new User();

        try {
            Connection connection = H2DatabaseConnection.getConnectionToDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from user where username = ?"
            );
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Could not execute a query", e);
        }

        return user;
    }

    public User insert(User user) throws Exception {
        try {
            Connection connection = H2DatabaseConnection.getConnectionToDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO USER (ID,USERNAME,PASSWORD,NAME,GENDER,AGE) VALUES (?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getName());
            preparedStatement.setString(5,user.getGender());
            preparedStatement.setInt(6,user.getAge());

            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return user;
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Could not execute a query", e);
        }
        throw new Exception("error");


    }

}
