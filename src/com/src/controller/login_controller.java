package com.src.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.User;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/login_controller")
public class login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public login_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("question");
		request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User u=new User();
		u.setEmail(email);
		u.setPassword(password);
		DbInterface db=RegistrationFactory.getInstance();
		u=db.loginVerify(u);
		if(u!=null)
		{

			List certificates=db.getCertificates(u.getEmail());
			List experience=db.getWorkExperience(u.getEmail());
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			session.setAttribute("certificates", certificates);
			session.setAttribute("experience", experience);
			request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("error", "Invalid Login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
