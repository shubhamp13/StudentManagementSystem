package controller;
import dao.StudentDao;
import dto.Student;

public class Login 
{
	public boolean loginStudent(String email,String password)
	{
		return new StudentDao().getStudent(email).getPassword().equals(password);
	}
}
