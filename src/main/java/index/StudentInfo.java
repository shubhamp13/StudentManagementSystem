package index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Student;

/**
 * Servlet implementation class StudentInfo
 */
public class StudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter printWriter=response.getWriter();
		response.setContentType("text/html");
		Student student=(Student)request.getAttribute("student");
		printWriter.println("<h1>Welcome To Student Management System!!!!!!!!!!!!!!!!!!!!</h1><br>");
		printWriter.println("<b>"+student.getName()+"</b><br>");
		printWriter.println("<b>"+student.getEmailId()+"</b><br>");
		printWriter.println("<b>"+student.getGender()+"</b><br>");
		printWriter.println("<b>"+student.getPhoneNo()+"</b><br>");
		printWriter.println("<b>"+student.getAddress()+"</b><br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
