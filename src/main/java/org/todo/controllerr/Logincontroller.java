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

@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		RegisterModel rm=new RegisterModel();
		rm.setUsername(username);
		rm.setPassword(password);
		LoginService ls=new LoginServiceImple();
		RegisterModel amd=ls.isValidate(rm);
		if(amd!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("vp",rm);
			RequestDispatcher r=request.getRequestDispatcher("DashBoard2.html");
			r.forward(request, response);
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("login2.html");
			r.include(request, response);
//			out.println("<center><h1>invalid username and password</h1></center>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
