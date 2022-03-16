package com.multithreading.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		public static Connection getConnection()
		 {
	         Connection connection=null;
	        try {
	           
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "tyler1111");
	            return connection;
	        } catch (ClassNotFoundException ex) {
	           // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	           // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return connection;
	    }

}
