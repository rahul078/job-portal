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

@WebServlet("/search_job")
public class search_job extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public search_job() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbInterface db = RegistrationFactory.getInstance();
		User u=(User) request.getSession().getAttribute("user");
		List<Vacancy> v=db.getJobs(u.getEdu_qualification(),u.getEmail());
		request.setAttribute("vacancy", v);
		request.getRequestDispatcher("WEB-INF/search_job.jsp").forward(request,response);
	}

}
