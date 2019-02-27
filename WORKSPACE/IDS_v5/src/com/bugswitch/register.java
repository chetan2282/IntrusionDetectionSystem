package com.bugswitch;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DbConnection;


public class register extends HttpServlet
{
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs;
	String fname;
	String mname;
	String lname;
	String dob;
	int age;
	String gender;
	
	String address;
	String city;
	String email;
	String mobile;
	String username;
	String password;
	
	
		public void init()
		{
			
			try
			{
				
				con = DbConnection.getConnection();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		
		public void doPost(HttpServletRequest req,HttpServletResponse res)
		{
			
			fname=req.getParameter("fname");
			mname=req.getParameter("mname");
			lname=req.getParameter("lname");
			dob=req.getParameter("dob");
			age=Integer.parseInt(req.getParameter("age"));			
			gender=req.getParameter("gender");
			address=req.getParameter("address");
			city=req.getParameter("city");
			email=req.getParameter("email");
			mobile=req.getParameter("mobile");
			username=req.getParameter("username");
			password=req.getParameter("password");
			
			System.out.println("-------Catch values of patient while registration------");
			System.out.println("pfname"+fname);
			System.out.println("pmname"+mname);
			System.out.println("plname"+lname);
			System.out.println("dob"+dob);
			System.out.println("age"+age);
			System.out.println("gender"+gender);
			System.out.println("address"+address);
			System.out.println("city"+city);
			System.out.println("email"+email);
			System.out.println("mobile"+mobile);
			System.out.println("username"+username);
			System.out.println("password"+password);
			
			
			
			
			try 
			{
				PrintWriter out=res.getWriter();
				
				ps=con.prepareStatement("insert into mem_info(firstname,middlename,lastname,dob,age,gender,address,city,email,mobile,username,password)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,fname);
				ps.setString(2,mname);
				ps.setString(3,lname);
				ps.setString(4, dob);
				ps.setInt(5,age);
				ps.setString(6, gender);
				ps.setString(7, address);
				ps.setString(8, city);
				ps.setString(9, email);
				ps.setString(10, mobile);
				ps.setString(11, username);
				ps.setString(12, password);
				
					int result=ps.executeUpdate();
				 
				if (result > 0)
				{
					System.out.println("Registration successfull");
					res.sendRedirect("index.jsp?registered");
					
					
				}
				else
				{
					System.out.println("Ragistration failed");
				}
			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
			}

	}
		
		public void distroy()
		{
			
			try
			{
				ps.close();
				con.close();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		
			



}
