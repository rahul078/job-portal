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

import com.src.model.Certificates;
import com.src.model.User;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/addCertificate")
public class addCertificate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addCertificate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_no=request.getParameter("certificate");
		System.out.println(c_no);
		User u=(User) request.getSession().getAttribute("user");
		DbInterface db=RegistrationFactory.getInstance();
		try {
			db.deleteCertificate(c_no);
			List certificates=db.getCertificates(u.getEmail());
			HttpSession session=request.getSession();
			session.setAttribute("certificates", certificates);
			request.getRequestDispatcher("WEB-INF/addCertificate.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Certificates c=new Certificates();
		User u=(User) request.getSession().getAttribute("user");
		System.out.println(u.getEmail());
		c.setC_no(request.getParameter("c_no"));
		c.setYear(request.getParameter("year"));
		c.setDescription(request.getParameter("description"));
		DbInterface db=RegistrationFactory.getInstance();
		try {
			db.addCertificates(c,u.getEmail());
			List certificates=db.getCertificates(u.getEmail());
			HttpSession session=request.getSession();
			session.setAttribute("certificates", certificates);
			request.getRequestDispatcher("WEB-INF/addCertificate.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
