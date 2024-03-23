package org.todo.controllerr;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.todo.module.RegisterModel;
import org.todo.service.LoginService;
import org.todo.service.LoginServiceImple;
import org.todo.service.registeraddservice;
import org.todo.service.registeraddserviceimple;
@WebServlet("/profile")
public class profile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		RegisterModel rm=(RegisterModel) session.getAttribute("vp");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Register</title><link rel='stylesheet' href='css/DashBoard2.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("DashBoard2.html");
		r.include(request, response);
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='vp'>");
		out.println("<input type='hidden' name='id' value='"+rm.getId()+"' class='control' placeholder='Enter Your Id'/><br><br>");
		out.println("<input type='text' name='fname' value='"+rm.getFname()+"' class='control' placeholder='Enter Your Fname'/><br><br>");
		out.println("<input type='text' name='lname' value='"+rm.getLname()+"' class='control' placeholder='Enter Your Lname'/><br><br>");
		out.println("<input type='text' name='username' value='"+rm.getUsername()+"' class='control' placeholder='Enter Your Username'/><br><br>");
		out.println("<input type='password' name='password' value='"+rm.getPassword()+"' class='control' placeholder='Enter Your password'/><br><br>");
		out.println("<input type='submit' name='s' value='Update Profile' class='control1'>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			RegisterModel rmm=new RegisterModel();
			rmm.setId(id);
			rmm.setFname(fname);
			rmm.setLname(lname);
			rmm.setUsername(username);
			rmm.setPassword(password);
			LoginService ls=new LoginServiceImple();
			boolean b=ls.isUpdate(rmm);
			if(b)
			{
				out.println("<center><h3>Update successfully........</h3></center>");
			}
			else
			{
				out.println("<center><h3>Not updated........</h3></center>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
