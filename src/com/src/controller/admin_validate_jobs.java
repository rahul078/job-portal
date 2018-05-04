package com.src.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.Vacancy;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/admin_validate_jobs")
public class admin_validate_jobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public admin_validate_jobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbInterface db = RegistrationFactory.getInstance();
		List<Vacancy> v = db.getVacancy();
		request.setAttribute("jobs",v);
		request.getRequestDispatcher("WEB-INF/admin_validate_jobs.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		DbInterface db = RegistrationFactory.getInstance();
		String job_id=request.getParameter("job_id");
		db.validate_job(job_id);
		List<Vacancy> v = db.getVacancy();
		request.setAttribute("jobs",v);
		request.getRequestDispatcher("WEB-INF/admin_validate_jobs.jsp").forward(request, response);
		
		
	}

}
