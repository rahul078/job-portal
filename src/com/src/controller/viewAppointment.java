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


@WebServlet("/viewAppointment")
public class viewAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public viewAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u=(User)session.getAttribute("user");
		String email=u.getEmail();
		DbInterface db = RegistrationFactory.getInstance();
		List appointments = db.getAppointments(email);
		request.setAttribute("appointments", appointments);
		request.getRequestDispatcher("WEB-INF/viewAppointment.jsp").forward(request, response);
	}

}
