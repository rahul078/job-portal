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
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;

@WebServlet("/aptitude")
public class aptitude extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public aptitude() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbInterface db = RegistrationFactory.getInstance();
		HttpSession session = request.getSession();
		User u=(User)session.getAttribute("user");
		int level=u.getLevel();
		if(level>4)
		{
			request.setAttribute("msg", "You Have reached maximum level");
			request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
		}
		else
		{
			try {
				List q=db.getQuestions(level);
				session.setAttribute("question", q);
				request.getRequestDispatcher("WEB-INF/user_question.jsp").forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		}
	}
}
