package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Hr;
import com.src.model.User;
import com.src.model.Vacancy;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;

@WebServlet("/hr_login_controller")
public class hr_login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public hr_login_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Hr hr = (Hr) session.getAttribute("hr");
		DbInterface db=RegistrationFactory.getInstance();
		List<Vacancy> v=db.getVacancy(hr.getEmail());
		session.setAttribute("vacancy", v);
		request.getRequestDispatcher("WEB-INF/hr_success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Hr u=new Hr();
		u.setEmail(email);
		u.setPassword(password);
		DbInterface db=RegistrationFactory.getInstance();
		try {
			u=db.hrLoginVerify(u);
			if(u!=null)
			{
				HttpSession session=request.getSession();
				List<Vacancy> v=db.getVacancy(email);
				session.setAttribute("vacancy", v);
				session.setAttribute("hr", u);
				request.getRequestDispatcher("WEB-INF/hr_success.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("error", "Invalid Login or Admin not confirmed identity");
				request.getRequestDispatcher("hr_login.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			request.setAttribute("error", "Invalid Login");
			request.getRequestDispatcher("hr_login.jsp").forward(request, response);
		}
	}

}
