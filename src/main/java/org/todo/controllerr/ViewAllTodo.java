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
@WebServlet("/ViewAllTodo")
public class ViewAllTodo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("DashBoard2.html");
		r.include(request, response);
		TodoAddService ts=new TodoAddServiceImple();
		List<todoModule> list=ts.ViewAllTodo();
		System.out.println("Date:"+list);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View All Todo</title>");
		out.println("<script type='text/javascript' src='login.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='v'>");
		out.println("<table class='vs'>");
		out.println("<input type='text' name='name' value='' class='con' onkeyup='searchCategory(this.value)'>");
		out.println("<tr><th>title</th><th>Date</th><th>Time</th><th>Description</th><th>Update</th><th>Delete</th></tr>");
		for(todoModule tm:list)
		{
			out.println("<tr>");
			out.println("<td>"+tm.getTitle()+"</td>");
			out.println("<td>"+tm.getTdate()+"</td>");
			out.println("<td>"+tm.getTime()+"</td>");
			out.println("<td>"+tm.getDescription()+"</td>");
			out.println("<td><a href='TodoAddUpdate?id="+tm.getId()+"&title="+tm.getTitle()+"&Description="+tm.getDescription()+"&tdate="+tm.getTdate()+"&time="+tm.getTime()+"&status="+tm.getStatus()+"'>Update</a></td>");
			out.println("<td><a href='TodoAddDelete?tid="+tm.getId()+"'>Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
