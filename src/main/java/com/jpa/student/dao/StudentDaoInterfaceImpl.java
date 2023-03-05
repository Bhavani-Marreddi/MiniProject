package com.jpa.student.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.jpa.student.model.Student;

public class StudentDaoInterfaceImpl implements StudentDaoInterface {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static String jpql;
	private static Query query;
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("bhavani");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	public String addStudent(Student student) {
	
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return "Record Added";
	}

	public String updateStudent(Student student) {
		jpql = "update Student s set s.studentDateOfJoning=?2 , s.studentName=?3 , s.studentTotalMarks=?4 , 					"
				+ "s.studentMailId=?5 , s.studentPhoneNo=?6 where s.studentId=?1";
		 query = entityManager.createQuery(jpql);
		query.setParameter(1, student.getStudentId());
		query.setParameter(2, student.getStudentDateOfJoning());
		query.setParameter(3, student.getStudentName());
		query.setParameter(4, student.getStudentTotalMarks());
		query.setParameter(5, student.getStudentMailId());
		query.setParameter(6, student.getStudentPhoneNo());

		entityTransaction.begin();
		query.executeUpdate();
		entityTransaction.commit();
		return "Record Updated";
	}

	public String deleteStudent(Integer studentId) {
	      jpql = "delete from Student s where s.studentId = ?1";
		 query = entityManager.createQuery(jpql);
		query.setParameter(1, studentId);
		entityTransaction.begin();
		query.executeUpdate();
		entityTransaction.commit();
		return "Record Deleted";
	}

	public List<Student> findStudent(Integer studentId) {
		 jpql = "select s from Student s where s.studentId=?1";
	    query = entityManager.createQuery(jpql);
		query.setParameter(1, studentId);
		List<Student> list = query.getResultList();
		return list;
	}

	public List<Student> findAllStudent() {
		jpql = "select stu from Student stu";
 	   query = entityManager.createQuery(jpql);
		List<Student> list = query.getResultList();
		return list;
	}

}
