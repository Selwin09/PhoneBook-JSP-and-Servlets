package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;

public class ContactDAO {
	private Connection connection;

	public ContactDAO(Connection connection) {
		super();
		this.connection = connection;
	};

	public boolean saveContact(Contact c) {
		boolean f = false;

		try {
			String sql = "insert into contact(name,email,phno,userid) values(?,?,?,?)";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, c.getName());
			preparedstatement.setString(2, c.getEmail());
			preparedstatement.setString(3, c.getPhno());
			preparedstatement.setInt(4, c.getUserId());

			int i = preparedstatement.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return f;

	}

	public List<Contact> getAllContact(int uId) {
		List<Contact> list = new ArrayList<Contact>();
		Contact c = null;
		try {
			String sql = "select * from contact where userid=?";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, uId);

			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				c = new Contact();
				c.setId(resultset.getInt(1));
				c.setName(resultset.getString(2));
				c.setEmail(resultset.getString(3));
				c.setPhno(resultset.getString(4));
				list.add(c);

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return list;
	}

	public Contact getContactByID(int cid) {
		Contact c = new Contact();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select * from contact where id=?");
			preparedstatement.setInt(1, cid);

			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				c.setId(resultset.getInt(1));
				c.setName(resultset.getString(2));
				c.setEmail(resultset.getString(3));
				c.setPhno(resultset.getString(4));

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return c;
	}

	public boolean updateContact(Contact c) {
		boolean f = false;

		try {
			String sql = "update contact set name=?,email=?,phno=? where id=?";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, c.getName());
			preparedstatement.setString(2, c.getEmail());
			preparedstatement.setString(3, c.getPhno());
			preparedstatement.setInt(4, c.getId());

			int i = preparedstatement.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteContactById(int id)
	{
		boolean f=false;
		try {
			String sql="delete from contact where id=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			int i=preparedstatement.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		} catch(Exception exception){
			exception.printStackTrace();
		}
		
		
		return f;
	}

}
