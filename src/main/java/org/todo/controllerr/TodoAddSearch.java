package org.todo.controllerr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.todo.module.todoModule;
import org.todo.service.TodoAddService;
import org.todo.service.TodoAddServiceImple;

@WebServlet("/TodoAddSearch")
public class TodoAddSearch extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// RequestDispatcher r=request.getRequestDispatcher("DashBoard2.html");
		// r.include(request, response);

		out.println("<html>");
		out.println("<head>");
		out.println("<title>View All Todo</title>");
		out.println("<script type='text/javascript' src='login.js'></script>");
		out.println("</head>");
		out.println("<table class='vs'>");
		out.println("<input type='text' name='ss' value='' onkeyup='searchCategory(this.value)'  class='con'  >");
		out.println(
				"<tr><th>title</th><th>Date</th><th>Time</th><th>Description</th><th>Update</th><th>Delete</th></tr>");

		String title = request.getParameter("todoName");
		TodoAddService ts = new TodoAddServiceImple();
		List<todoModule> list = ts.getByname(title);
		for (todoModule tm : list) {
			out.println("<tr>");
			out.println("<td>" + tm.getTitle() + "</td>");
			out.println("<td>" + tm.getTdate() + "</td>");
			out.println("<td>" + tm.getTime() + "</td>");
			out.println("<td>" + tm.getDescription() + "</td>");
			out.println("<td><a href='#'>Update</a></td>");
			out.println("<td><a href='#'>Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
