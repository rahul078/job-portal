package com.src.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.*;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;

@WebServlet("/hr_get_application")
public class hr_get_application extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public hr_get_application() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbInterface db = RegistrationFactory.getInstance();
		Hr hr = (Hr)request.getSession().getAttribute("hr");
		System.out.println(hr.getEmail());
		List<Application> app=db.getApplications(hr.getEmail());
			

		request.getSession().setAttribute("app", app);
		request.getRequestDispatcher("WEB-INF/hr_applications.jsp").forward(request, response);
	}

}
