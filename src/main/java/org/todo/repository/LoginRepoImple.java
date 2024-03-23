package org.todo.repository;

import org.todo.module.RegisterModel;

public class LoginRepoImple extends DBConfig implements LoginRepo{
	public RegisterModel isValidate(RegisterModel rm) {
		try
		{
			stmt=conn.prepareStatement("select * from registration where username=? and password=?");
			stmt.setString(1, rm.getUsername());
			stmt.setString(2, rm.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				rm.setId(rs.getInt(1));
				rm.setFname(rs.getString(2));
				rm.setLname(rs.getString(3));
				rm.setUsername(rs.getString(4));
				rm.setPassword(rs.getString(5));
				return rm;
			}
			else
			{
				return null;
			}
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}

	@Override
	public boolean isUpdate(RegisterModel rm) {
		 try
		 {
			 stmt=conn.prepareStatement("update registration set fname=?,lname=?,username=?,password=? where id=?");
			 stmt.setString(1,rm.getFname());
			 stmt.setString(2,rm.getLname());
			 stmt.setString(3,rm.getUsername());
			 stmt.setString(4,rm.getPassword());
			 stmt.setInt(5,rm.getId());
			 int val=stmt.executeUpdate();
			 if(val>0)
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 catch(Exception ex)
		 {
			 System.out.println("error is "+ex);
			 return false;
		 }
		
	}

}
