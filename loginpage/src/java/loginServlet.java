/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	

	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// From login.jsp, as a post method only the credentials are passed
	// Hence the parameters should match both in jsp and servlet and
	// then only values are retrieved properly
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
	
		System.out.println("emailId.." + emailId);
		System.out.println("password.." + password);
		
		if (emailId != null && emailId.equalsIgnoreCase("madhur") && password != null && password.equalsIgnoreCase("admin")) {
			
			HttpSession httpSession = request.getSession();
			
			httpSession.setAttribute("emailId", emailId);
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
	}
}


