package org.todo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DBConfig {
	   protected Connection conn;
	   protected ResultSet rs;
	   protected PreparedStatement stmt;
	   public DBConfig()
	   {
		   try
		   {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo?useSSL=false", "root", "Aai@8530");
		   }
		   catch(Exception ex)
		   {
			   System.out.println("exception is "+ex);
		   }
	   }
}
