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
import org.todo.module.todoModule;
import org.todo.service.TodoAddService;
import org.todo.service.TodoAddServiceImple;
@WebServlet("/TodoAddUpdate")
public class TodoAddUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String Description=request.getParameter("Description");
		String tdate=request.getParameter("tdate");
		Date d = Date.valueOf(tdate);
		String time=request.getParameter("time");
		int Status=Integer.parseInt(request.getParameter("status"));
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Register</title><link rel='stylesheet' href='css/DashBoard2.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("DashBoard2.html");
		r.include(request, response);
		out.println("<form name='frm' action='fupdate' method='POST'>");
		out.println("<div class='pp'>");
		out.println("<input type='hidden' name='idd' value='"+id+"' class='control' /><br><br>");
		out.println("<input type='text' name='ttl' value='"+title+"' class='control' /><br><br>");
		out.println("<input type='text' name='desc' value='"+Description+"' class='control'/><br><br>");
		out.println("<input type='date' name='tdt' value='"+d+"' class='control' /><br><br>");
		out.println("<input type='time' name='tmt' value='"+time+"' class='control' /><br><br>");
		out.println("<input type='text' name='sts' value='"+Status+"' class='control' /><br><br>");
		out.println("<input type='submit' name='sub' value='Update Todo' class='control1'>");
		out.println("</div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
