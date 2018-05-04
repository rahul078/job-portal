package com.src.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Hr;
import com.src.model.Vacancy;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/vacancy_controller")
public class vacancy_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public vacancy_controller() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int job_id=Integer.parseInt(request.getParameter("vacancy"));
		DbInterface db = RegistrationFactory.getInstance();
		db.deleteJob(job_id);
		HttpSession session=request.getSession();
		Hr hr=(Hr) session.getAttribute("hr");
		List<Vacancy> v=db.getVacancy(hr.getEmail());
		session.setAttribute("vacancy", v);
		request.getRequestDispatcher("WEB-INF/hr_success.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vacancy v=new Vacancy();
		Hr hr = (Hr) request.getSession().getAttribute("hr");
		v.setEmail(hr.getEmail());
		v.setCompany(hr.getCompany());
		v.setPhone_number(hr.getPhone_number());
		v.setPosition(request.getParameter("position"));
		v.setDeadline(request.getParameter("deadline"));
		v.setMin_qualification(request.getParameter("min_qualification"));
		v.setSalary(request.getParameter("salary"));
		DbInterface db = RegistrationFactory.getInstance();
		db.addVacancy(v);
		List<Vacancy> v1=db.getVacancy(hr.getEmail());
		HttpSession session=request.getSession();
		session.setAttribute("vacancy", v1);
		request.getRequestDispatcher("WEB-INF/hr_success.jsp").forward(request, response);
	}

}
