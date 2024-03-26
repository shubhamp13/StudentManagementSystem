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
	public Student getStudent(String emailId)
	{
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, emailId);
		return dbStudent;
	}
	public boolean  deleteStudent(String emailId)
	{
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class,emailId);
		if(dbStudent!=null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(dbStudent);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
		
	}
	public boolean updateStudent(String emailId,Student dbStudent)
	{
		EntityManager entityManager=getEntityManager();
		Student student=entityManager.find(Student.class, emailId);
		if(student!=null)
		{
			entityManager.getTransaction().begin();
			dbStudent.setEmailId(emailId);
			entityManager.merge(dbStudent);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}
}
