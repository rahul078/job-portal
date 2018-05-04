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

import com.src.model.Hr;
import com.src.model.User;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;

@WebServlet("/hr_register_controller")
public class hr_register_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public hr_register_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hr u=new Hr();
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String company=request.getParameter("company");
		String c_address=request.getParameter("c_address");
		String phone_number=request.getParameter("phone_number");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n",email,name,company,phone_number,c_address,password,cpassword);
		
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
		details.put("name", name);
		details.put("company", company);
		details.put("phone_number", phone_number);
		details.put("c_address", c_address);
		if(errors.isEmpty())
		{
			DbInterface db=RegistrationFactory.getInstance();
				int result=db.hr_register(details);
				if(result==-1)
				{
					request.setAttribute("error", "Registration failed");
					request.getRequestDispatcher("hr_login.jsp").forward(request, response);
				}
				else
					request.getRequestDispatcher("hr_login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("errors", errors);
			request.setAttribute("details",details);
			request.getRequestDispatcher("hr_login.jsp").forward(request,response);
		}
		
	}

}
