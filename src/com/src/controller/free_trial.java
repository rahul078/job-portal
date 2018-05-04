package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Questions;
import com.src.services.DbInterface;
import com.src.services.RegistrationFactory;


@WebServlet("/free_trial")
public class free_trial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public free_trial() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbInterface db=RegistrationFactory.getInstance();
		try {
			List question=db.getQuestions(0);
			
			//Below code is to generate the questions randomly
			for(int i=0;i<(new Random()).nextInt(5);i++)
			{
				Collections.shuffle(question);
			}
			// end of shuffle
			
			HttpSession session = request.getSession();
			session.setAttribute("question", question);
			request.getRequestDispatcher("free_trial.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("homepage.html").forward(request, response);

			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int correct=0;
		List q=(List<Questions>) request.getSession().getAttribute("question");
		int no=q.size();
		for(int i=0;i<no;i++)
		{
			Questions q1=(Questions) q.remove(0);
			int c_opt=q1.getCorrect_opt();
			if(c_opt==(Integer.parseInt(request.getParameter(q1.getQuestion()))))
			{
				correct+=1;
			}
			
		}
		request.getSession().invalidate();
		request.setAttribute("correct","You have answered "+correct+" questions correctly out of "+no+" questions.To unlock more questions and other options, Sign in" );
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	}

}
