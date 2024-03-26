package index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

/**
 * Servlet implementation class UpdateServlet
 */

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
//		student.setEmailId(emailId);
		student.setGender(gender);
		student.setPassword(password);
		student.setPhoneNo(phoneNo);
		student.setStream(course);
		if(new StudentDao().updateStudent(emailId, student))
		{
			printWriter.print("<h1>Updated</h1>");
		}
		else
		{
			printWriter.print("<h1>Not Updated</h1>");
		}
		
	}

}
