package org.todo.controllerr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DashBoard")
public class DashBoard extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    out.println("<html>");
		out.println("<head>");
		out.println("<title>Register</title><link rel='stylesheet' href='css/DashBoard2.css'>");
		out.println("</head>");
		out.println("<body>");
	    out.println("<div>");
        out.println("<ul>");
        out.println("<li><a href='TodoAdd'>Add Todo</a></li>");
        out.println("<li><a href='ViewAllTodo'>View All</a></li>");
        out.println("<li><a href='profile'>Profile</a></li>");
        out.println("<li><a href='Login2.html'>LogOut</a></li>");
        out.println("</ul>");
        out.println("</div>");
      out.println("</body>");
	  out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
