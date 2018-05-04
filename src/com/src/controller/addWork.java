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

import com.src.model.User;
import com.src.model.Work_Experience;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/addWork")
public class addWork extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addWork() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desc=request.getParameter("work");
		//System.out.println(desc);
		User u=(User) request.getSession().getAttribute("user");
		DbInterface db=RegistrationFactory.getInstance();
		try {
			db.deleteExperience(desc,u.getEmail());
			List experience=db.getWorkExperience(u.getEmail());
			HttpSession session=request.getSession();
			session.setAttribute("experience", experience);
			request.getRequestDispatcher("WEB-INF/addWork.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Work_Experience w=new Work_Experience();
		w.setFrom_year(request.getParameter("from_year"));
		w.setTo_year(request.getParameter("to_year"));
		w.setDescription(request.getParameter("description"));
		User u=(User) request.getSession().getAttribute("user");
		DbInterface db=RegistrationFactory.getInstance();
		try {
			db.addExperience(w,u.getEmail());
			List experience=db.getWorkExperience(u.getEmail());
			HttpSession session=request.getSession();
			session.setAttribute("experience", experience);
			request.getRequestDispatcher("WEB-INF/addWork.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
