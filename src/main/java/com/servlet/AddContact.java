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
import com.entity.Contact;

@WebServlet("/addContact")
public class AddContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId=Integer.parseInt(request.getParameter("userid"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");

        //System.out.println(userId+" "+name+" "+email+" "+" "+phno);
		Contact contact=new Contact(name,email,phno,userId);
		ContactDAO dao=new ContactDAO(DbConnect.getConnection());
		
		HttpSession session=request.getSession();
		boolean f=dao.saveContact(contact);
		if(f)
		{
			session.setAttribute("successMsg", "Contact saved");
			response.sendRedirect("addContact.jsp");
		}
		else
		{
			session.setAttribute("failedMsg", "Something wrong on server..");
			response.sendRedirect("addContact.jsp");
		}
	}
	

}
