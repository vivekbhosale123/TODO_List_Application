package org.todo.repository;

import org.todo.controllerr.*;
import org.todo.module.RegisterModel;

public class registeraddrepositoryimple extends DBConfig implements registeraddrepository {

	public boolean isAddRegister(RegisterModel rm) {
		try {
			stmt=conn.prepareStatement("insert into registration values('0',?,?,?,?)");
			stmt.setString(1,rm.getFname());
			stmt.setString(2, rm.getLname());
			stmt.setString(3,rm.getUsername());
			stmt.setString(4,rm.getPassword());
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
