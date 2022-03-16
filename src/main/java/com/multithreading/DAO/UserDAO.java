package com.multithreading.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.multithreading.Beans.User;

public class UserDAO {

	   public int saveUser(User user){
         int rows = 0;
       try {
         
           Connection connection = DBConnection.getConnection();
           PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?)");
           statement.setInt(1, user.getId());
           statement.setString(2, user.getName());
           statement.setString(3, user.getEmailAddress());
           rows = statement.executeUpdate();
       } catch (SQLException ex) {
          // Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return rows;
   }
	
}
