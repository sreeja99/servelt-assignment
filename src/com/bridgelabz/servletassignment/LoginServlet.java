package com.bridgelabz.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Login Servlet Testing", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if (user.matches("^[A-Z][a-zA-Z]{2,}$") && pwd.matches("^(?=\\S{8,})(?=\\S*[A-Z])(?=\\S*[\\d])[\\w]*[^\\w\\s][\\w]*")) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user-name or password is Invalid.</font>");
			rd.include(request, response);
		}
	}

}
