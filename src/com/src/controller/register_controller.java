package com.src.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.User;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/register_controller")
public class register_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public register_controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		String email=request.getParameter("email");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		String phone_number=request.getParameter("phone_number");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String edu_qualification=request.getParameter("edu_qualification");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",email,fname,lname,dob,phone_number,city,state,edu_qualification,password,cpassword);
		
		HashMap<String,String> errors=new HashMap<>();
		HashMap<String,String> details=new HashMap<>();
		
		Pattern emailpattern=Pattern.compile(".+@.+.com");
		Matcher emailmatch=emailpattern.matcher(email);
		
		
		if(!emailmatch.matches())
		{
			errors.put("email", "Enter a valid Email");
		}
		else
		{
			details.put("email", email);		
		}
		if(password==null|password.length()<=5)
		{
			errors.put("password", "Enter a valid password");
			
		}
		else if(!password.equals(cpassword))
		{
			errors.put("password", "Password and Confirm Password must be same");
		}
		else
		{
			details.put("password", password);
		}
		details.put("fname", fname);
		details.put("lname", lname);
		details.put("dob", dob);
		details.put("phone_number", phone_number);
		details.put("city", city);
		details.put("state", state);
		details.put("edu_qualification", edu_qualification);
		if(errors.isEmpty())
		{
			DbInterface db=RegistrationFactory.getInstance();
			try
			{
				db.register(details);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				request.setAttribute("error", "Registration failed");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errors", errors);
			request.setAttribute("details",details);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
	}

}
