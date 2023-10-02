/*Application name: PhoneBook Application
Author name: Selwin isac neilsingh J
Created on : 05/02/2023
Reviewed by: Anushya
Reviewed on:06/04/2023
*/



package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		
		
		
		
		UserDAO dao=new UserDAO(DbConnect.getConnection());
		User user=dao.loginUser(email, pass);
		HttpSession session=request.getSession();
		if(user != null)
		{
			session.setAttribute("user",user);
			response.sendRedirect("index.jsp");
			//System.out.println("User is Available=" +user);
			
		} else {
			session.setAttribute("invalidMsg","Invalid Email & Password");
			response.sendRedirect("index.jsp");
			//System.out.println("User is not Available=" +user);
		}
	}

}
