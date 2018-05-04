package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.Appointment;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/hr_appoint")
public class hr_appoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public hr_appoint() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Appointment a=new Appointment();
		int app_id=Integer.parseInt(request.getParameter("app_id"));
		String email=request.getParameter("email");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		System.out.println(app_id+email+date+time);
		a.setApp_id(app_id);
		a.setEmail(email);
		a.setApp_date(date);
		a.setApp_time(time);
		DbInterface db = RegistrationFactory.getInstance();
		db.appoint(a);
		request.getRequestDispatcher("WEB-INF/close.jsp").forward(request, response);
	}

}
