package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;import org.hibernate.dialect.InnoDBStorageEngine;

import dto.Student;

public class StudentDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("shubham").createEntityManager();
	}
	public void saveStudent(Student student)
	{
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
	}
	public boolean findStudent(String emailId,String password)
	{
		boolean b=false;
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction().begin();
		Student dbStudent=entityManager.find(Student.class,emailId);
		if(dbStudent!=null)
		{
			b=dbStudent.getPassword().equals(password);
		}
		entityManager.getTransaction().commit();
		return b;
	}
	public Student getStudent(String emailId)
	{
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, emailId);
		return dbStudent;
	}
}
