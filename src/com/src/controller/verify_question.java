package com.src.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Questions;
import com.src.model.User;
import com.src.services.RegistrationFactory;


@WebServlet("/verify_question")
public class verify_question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public verify_question() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
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
		if(correct/no*100>70)
		{
			request.setAttribute("msg", "Congrats on advancing to next level. You have answered "+correct+" out of "+no+" questions");
			HttpSession session = request.getSession();
			User user =(User) session.getAttribute("user");
			user.setLevel(user.getLevel()+1);
			RegistrationFactory.getInstance().levelUp(user.getEmail(),user.getLevel());
			
			session.setAttribute("user", user);
		}
		else
		{
			request.setAttribute("msg", "Failed to advance to next level. You have answered "+correct+" out of "+no+" questions");
		}
		request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
		
	}

}
