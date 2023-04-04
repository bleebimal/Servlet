package service;

import model.User;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bmal on 5/27/16.
 */
public class UserService {

    public static boolean registerUser(User user) throws SQLException, ClassNotFoundException {
        boolean registered = false;
        String username = user.getUsername();
        String password = user.getPassword();
        String name = user.getName();

        Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement register = connection.prepareStatement("INSERT INTO users VALUES(?,?,?)");
            register.setString(1, username);
            register.setString(2, password);
            register.setString(3, name);

            if(register.executeUpdate()==1){
                registered = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Register service called");
        return registered;
    }

    public static boolean loginUser(String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        Boolean retVal = false;
        try {
            PreparedStatement register = connection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
            register.setString(1,username);
            register.setString(2, password);
            ResultSet res = register.executeQuery();
            if (res.next()){
                retVal = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }
}
