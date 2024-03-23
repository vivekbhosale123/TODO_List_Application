package org.todo.controllerr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.todo.module.RegisterModel;
import org.todo.module.todoModule;
import org.todo.service.TodoAddService;
import org.todo.service.TodoAddServiceImple;
import org.todo.service.registeraddservice;
import org.todo.service.registeraddserviceimple;
@WebServlet("/TodoAdd")
public class TodoAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Register</title><link rel='stylesheet' href='css/DashBoard2.css'>");
//		out.println("</head>");
//		out.println("<body>");
//		RequestDispatcher r=request.getRequestDispatcher("DashBoard2.html");
//		r.include(request, response);
//		out.println("<form name='frm' action='' method='POST'>");
//		out.println("<div class='pp'>");
//		out.println("<input type='hidden' name='id' value='' class='control' placeholder='Enter Your Id'/><br><br>");
//		out.println("<input type='text' name='title' value='' class='control' placeholder='Enter Todo'/><br><br>");
//		out.println("<input type='text' name='Description' value='' class='control' placeholder='Enter Description'/><br><br>");
//		out.println("<input type='date' name='tdate' value='' class='control' placeholder='Enter date'/><br><br>");
//		out.println("<input type='time' name='time' value='' class='control' placeholder='Enter Time'/><br><br>");
//		out.println("<input type='text' name='status' value='' class='control' placeholder='Enter Status'/><br><br>");
//		out.println("<input type='submit' name='s' value='Add Todo' class='control1'>");
//		out.println("</div>");
//		out.println("</form>");
		String btn=request.getParameter("s");
		
		if(btn!=null)
		{
			//System.out.println("S in if Btn--"+btn);
			String title=request.getParameter("title");
			String Description=request.getParameter("Description");
			String tdate=request.getParameter("tdate");
			Date d = Date.valueOf(tdate);
			String time=request.getParameter("time");
			//Time t = Time.valueOf(time);
			//System.out.println("Time---->"+time);
			int Status=Integer.parseInt(request.getParameter("status"));
			//System.out.println("status---->"+Status);
			todoModule tm=new todoModule();
			tm.setTitle(title);
			tm.setDescription(Description);
			tm.setTdate(d);
			tm.setTime(time);
			tm.setStatus(Status);
			TodoAddService ts=new TodoAddServiceImple();
			boolean b=ts.isTodoAdd(tm);
			if(b)
			{
				RequestDispatcher r=request.getRequestDispatcher("ViewAllTodo");
				r.forward(request, response);			
			}
			else
			{
				RequestDispatcher r=request.getRequestDispatcher("AddTodo.html");
				r.include(request, response);
			}
		}
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
