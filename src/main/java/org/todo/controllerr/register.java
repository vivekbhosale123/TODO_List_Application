package org.todo.controllerr;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.todo.module.RegisterModel;
import org.todo.service.*;
import org.todo.repository.registeraddrepositoryimple;
@WebServlet("/register")
public class register extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Register</title><link rel='stylesheet' href='css/DashBoard2.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='vv'>");
		out.println("<input type='hidden' name='id' value='' class='control' placeholder='Enter Your Id'/><br><br>");
		out.println("<input type='text' name='fname' value='' class='control' placeholder='Enter Your Fname'/><br><br>");
		out.println("<input type='text' name='lname' value='' class='control' placeholder='Enter Your Lname'/><br><br>");
		out.println("<input type='text' name='username' value='' class='control' placeholder='Enter Your Username'/><br><br>");
		out.println("<input type='password' name='password' value='' class='control' placeholder='Enter Your password'/><br><br>");
		out.println("<input type='submit' name='s' value='Register' class='control1'>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
//			int id=Integer.parseInt(request.getParameter("id"));
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			RegisterModel rm=new RegisterModel();
//			rm.setId(id);
			rm.setFname(fname);
			rm.setLname(lname);
			rm.setUsername(username);
			rm.setPassword(password);
			registeraddservice ras=new registeraddserviceimple();
			boolean b=ras.isAddRegister(rm);
			if(b)
			{
				out.println("<center><h1>Register successfully........</h1></center>");
			}
			else
			{
				out.println("<center><h1>Not Registered........</h1><center>");
			}
		}
//		else
//		{
//			out.println("<h1>Some Problem is here........</h1>");
//		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
