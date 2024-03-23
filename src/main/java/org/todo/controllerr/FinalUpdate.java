package org.todo.controllerr;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.todo.module.todoModule;
import org.todo.service.TodoAddService;
import org.todo.service.TodoAddServiceImple;

/**
 * Servlet implementation class FinalUpdate
 */
@WebServlet("/fupdate")
public class FinalUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String btn=request.getParameter("sub");
		
			int id=Integer.parseInt(request.getParameter("idd"));
			String title=request.getParameter("ttl");
			String Description=request.getParameter("desc");
			String tdate=request.getParameter("tdt");
			Date d = Date.valueOf(tdate);
			String time=request.getParameter("tmt");
			Time t = Time.valueOf(time);
			int Status=Integer.parseInt(request.getParameter("sts"));
			todoModule tm=new todoModule();
			tm.setId(id);
			tm.setTitle(title);
			tm.setDescription(Description);
			tm.setTdate(d);
			tm.setTime(time);
			tm.setStatus(Status);
			TodoAddService ts=new TodoAddServiceImple();
			boolean b=ts.isupdate(tm);
			if(b)
			{
				RequestDispatcher r1=request.getRequestDispatcher("ViewAllTodo");
	            r1.forward(request, response);
			}
			else
			{
				RequestDispatcher r1=request.getRequestDispatcher("TodoAddUpdate");
	            r1.include(request, response);
			}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
