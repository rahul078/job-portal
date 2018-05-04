package com.src.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;

@WebServlet("/admin_login_controller")
public class admin_login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_login_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbInterface db=RegistrationFactory.getInstance();
		String email=request.getParameter("email");
		System.out.println(email);
		db.updateHr(email);
		List hr=db.getPendingHr();
		if(hr==null)
		{
			request.setAttribute("msg",	"No pending Applications for registration");
		}
		else
		{
			request.setAttribute("hr",	hr);
		}
		request.getRequestDispatcher("WEB-INF/admin_success.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		DbInterface db = RegistrationFactory.getInstance();
		try {
			int r=db.adminLogin(id,password);
			if(r==0)
			{
				List hr=db.getPendingHr();
				if(hr==null)
				{
					request.setAttribute("msg",	"No pending Applications for registration");
				}
				else
				{
					request.setAttribute("hr",	hr);
				}
				request.getRequestDispatcher("WEB-INF/admin_success.jsp").forward(request, response);
			}
			
			else
			{
				request.setAttribute("error", "Invalid login Credentials");
				request.getRequestDispatcher("admin_login.jsp").forward(request, response);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

}
