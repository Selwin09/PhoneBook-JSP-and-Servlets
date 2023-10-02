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

@WebServlet("/update")
public class EditContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");

		Contact c=new Contact();
		c.setId(cid);
		c.setName(name);
		c.setEmail(email);
		c.setPhno(phno);
		
		ContactDAO dao=new ContactDAO(DbConnect.getConnection());
		HttpSession session=request.getSession();
		boolean f=dao.updateContact(c);
		if(f)
		{
			session.setAttribute("successMsg", "Contact updated..");
			response.sendRedirect("viewContact.jsp");
		}
		else
		{
			session.setAttribute("failedMsg", "Something wrong on server..");
			response.sendRedirect("editcontact.jsp?cid="+cid);
		}		
		
		
	}

}
