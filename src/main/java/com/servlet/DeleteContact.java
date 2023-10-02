package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnect;
import com.dao.ContactDAO;

@WebServlet("/delete")
public class DeleteContact extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		ContactDAO dao=new ContactDAO(DbConnect.getConnection());
		
		boolean f=dao.deleteContactById(cid);
		HttpSession session=request.getSession();
		if(f)
		{
			session.setAttribute("successMsg", "Contact Deleted Successfully");
			response.sendRedirect("viewContact.jsp");
		} else {
			session.setAttribute("failedMsg", "Something wrong on server..");
			response.sendRedirect("viewContact.jsp");
		}
	}
	

}
