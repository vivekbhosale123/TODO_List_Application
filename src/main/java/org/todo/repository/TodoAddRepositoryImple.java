package org.todo.repository;
import java.util.ArrayList;
import java.util.List;

import org.todo.module.todoModule;
public class TodoAddRepositoryImple extends DBConfig implements TodoAddRepository{
    List<todoModule> list=new ArrayList<todoModule>();
	@Override
	public boolean isTodoAdd(todoModule tm) {
		try
		{
			stmt=conn.prepareStatement("insert into todo values('0',?,?,?,?,?)");
			stmt.setString(1,tm.getTitle());
			stmt.setString(2,tm.getDescription());
			stmt.setDate(3,tm.getTdate());
			stmt.setInt(4,tm.getStatus());
			stmt.setString(5,tm.getTime());
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

	@Override
	public List<todoModule> ViewAllTodo() {
		try {
			stmt=conn.prepareStatement("select * from todo where status=1");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				todoModule tm=new todoModule();
				tm.setId(rs.getInt(1));
				tm.setTitle(rs.getString(2));
				tm.setDescription(rs.getString(3));
				tm.setTdate(rs.getDate(4));
				tm.setTime(rs.getString(6));
				tm.setStatus(rs.getInt(5));
				list.add(tm);
			}
			return list;
		}
		catch(Exception ex)
		{
			System.out.println("when check status are 1 then print it error is"+ex);
			return null;
		}
	}

	@Override
	public List<todoModule> getByname(String name) {
	     try
	     {
	    	 System.out.println("Sr Name:"+name);
	    	 stmt=conn.prepareStatement("select * from todo where status=1 and title like '"+name+"%'");
	    	 rs=stmt.executeQuery();
	    	 while(rs.next())
	    	 {
	    		    todoModule tm=new todoModule();
					tm.setId(rs.getInt(1));
					tm.setTitle(rs.getString(2));
					tm.setDescription(rs.getString(3));
					tm.setTdate(rs.getDate(4));
					tm.setTime(rs.getString(6));
					tm.setStatus(rs.getInt(5));
					list.add(tm);
	    	 }
	    	 System.out.println("DATA:"+list);
	    	 return list;
	     }
	     catch(Exception ex)
	     {
	    	 System.out.println("when insialize status error is "+ex);
	    	 return null;
	     }
	}

	@Override
	public boolean isupdate(todoModule tm) {
		try
		{
			stmt=conn.prepareStatement("update todo set title=?,description=?,tdate=?,time=?,status=? where id=?");
			stmt.setString(1,tm.getTitle());
			stmt.setString(2,tm.getDescription());
			stmt.setDate(3,tm.getTdate());
			stmt.setString(4,tm.getTime());
			stmt.setInt(5,tm.getStatus());
			stmt.setInt(6,tm.getId());
			int val=stmt.executeUpdate();
			System.out.println("Value--->"+val);
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
			System.out.println("when update value error is "+ex);
			return false;
		}
	}

	@Override
	public boolean isDelete(int id) {
		try
		{
			stmt=conn.prepareStatement("delete from todo where id=?");
			stmt.setInt(1, id);
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
