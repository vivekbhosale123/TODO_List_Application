package org.todo.controllerr;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.todo.service.TodoAddService;
import org.todo.service.TodoAddServiceImple;
@WebServlet("/TodoAddDelete")
public class TodoAddDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int uid=Integer.parseInt(request.getParameter("tid"));
		TodoAddService ads=new TodoAddServiceImple();
		boolean b=ads.isDelete(uid);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("ViewAllTodo");
			r.include(request, response); 
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("ViewAllTodo");
			r.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
