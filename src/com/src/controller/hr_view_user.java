package com.src.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.User;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/hr_view_user")
public class hr_view_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public hr_view_user() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		DbInterface db = RegistrationFactory.getInstance();
		User u=db.getInfo(email);
		List workExperience = db.getWorkExperience(email);
		request.setAttribute("app_id", request.getParameter("app_id"));
		List certificates=db.getCertificates(email);
		//System.out.println(request.getParameter("app_id"));
		request.setAttribute("user", u);
		request.setAttribute("experience", workExperience);
		request.setAttribute("certificates", certificates);
		request.getRequestDispatcher("WEB-INF/hr_View_Application.jsp").forward(request, response);
	}

}
