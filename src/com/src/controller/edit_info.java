package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.*;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/edit_info")
public class edit_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public edit_info() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/change_info.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		u.setFname(request.getParameter("fname"));
		u.setLname(request.getParameter("lname"));
		u.setCity(request.getParameter("city"));
		u.setState(request.getParameter("state"));
		u.setEdu_qualification(request.getParameter("edu_qualification"));
		u.setPhone_number(request.getParameter("phone_number"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		u.setDob(request.getParameter("dob"));
		HttpSession session=request.getSession();
		session.setAttribute("user", u);
		DbInterface db=RegistrationFactory.getInstance();		
		try {
			db.changeInfo(u);

			request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
		}
		
			
		
	}

}
