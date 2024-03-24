package index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

public class StudentServlet extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter printWriter=resp.getWriter();
		resp.setContentType("text/html");
		String name=req.getParameter("studName");
		String course=req.getParameter("user_value");
		String gender=req.getParameter("user_gender");
		String emailId=req.getParameter("emailId");
		String phoneNo=req.getParameter("phoneNo");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		Student student=new Student();
		student.setName(name);
		student.setAddress(address);
		student.setEmailId(emailId);
		student.setGender(gender);
		student.setPassword(password);
		student.setPhoneNo(phoneNo);
		student.setStream(course);
		
		StudentDao dao=new StudentDao();
		dao.saveStudent(student);
		printWriter.println("Saved Succesfully");
	}
	
}
