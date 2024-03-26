package index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Login;
import dao.StudentDao;
import dto.Student;

public class LoginServlet extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		 PrintWriter printWriter=resp.getWriter();
		 String emailId=req.getParameter("emailId");
		 String password=req.getParameter("password");
		 String check=req.getParameter("register");
		 if(check!=null)
		 {
			 RequestDispatcher dispatcher=req.getRequestDispatcher("register.html");
			 dispatcher.forward(req, resp);
		 }
	 
		if(new Login().loginStudent(emailId, password))
		{
			Student student=new StudentDao().getStudent(emailId);
			req.setAttribute("student",student);
			RequestDispatcher dispatcher=req.getRequestDispatcher("StudentInfo");
			dispatcher.forward(req, resp);
		
		}
		else
		{
			printWriter.print("<h1>Oops Something Wrong!!!!!!!!!!!!!!!!!!!</h1>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			resp.sendRedirect("https://www.google.com/");
			dispatcher.include(req, resp);
		}
		 
	}
	
}
