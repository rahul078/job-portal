package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.User;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;

@WebServlet("/apply_job")
public class apply_job extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public apply_job() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=(User) request.getSession().getAttribute("user");
		String job_id=request.getParameter("job_id");
		DbInterface db = RegistrationFactory.getInstance();
		db.applyJob(u.getEmail(),job_id);
		request.getRequestDispatcher("search_job").forward(request,response);
	}

}
