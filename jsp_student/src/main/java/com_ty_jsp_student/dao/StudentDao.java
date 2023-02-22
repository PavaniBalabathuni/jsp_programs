package com_ty_jsp_student.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com_ty_jsp_student.dto.Student;


public class StudentDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public Student saveStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
		
	}
	public Student loginStudent(String email) {
		EntityManager eManager=getEntityManager();
		Query query=eManager.createQuery("select st from Student st where st.email=?1");
		query.setParameter(1, email);
		Student student=(Student)query.getSingleResult();
		return student;
	}
	public List<Student> getStudentList(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Student s ");
		List<Student>list =query.getResultList();
		return list;
	}
	public boolean deleteEmployee(int id) {
		EntityManager eManager=getEntityManager();
		EntityTransaction entityTransaction=eManager.getTransaction();
		Student student=eManager.find(Student.class, id);
		if(student!=null) {
			entityTransaction.begin();
			eManager.remove(student);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
		
	}
	public Student getById(int id) {
		return getEntityManager().find(Student.class, id);
		
	}
	public Student updateEmployeeById(Student student) {
		EntityManager eManager=getEntityManager();
		EntityTransaction entityTransaction=eManager.getTransaction();
		
		
			entityTransaction.begin();
			eManager.merge(student);
			entityTransaction.commit();
		
		return student;
		
	}




}
