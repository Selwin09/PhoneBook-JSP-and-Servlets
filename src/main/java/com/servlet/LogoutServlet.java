package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		//session.getAttribute("user");
		session.removeAttribute("user");
		
		HttpSession session2=request.getSession();
		session2.setAttribute("logMsg", "Logout Successful");
		response.sendRedirect("login.jsp");
		
	}
	

}
