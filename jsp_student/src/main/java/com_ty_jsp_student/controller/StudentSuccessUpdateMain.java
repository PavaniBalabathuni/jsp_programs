                                                                                                                                                                package com_ty_jsp_student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_ty_jsp_student.dao.StudentDao;
import com_ty_jsp_student.dto.Student;



@WebServlet("/editor")
public class StudentSuccessUpdateMain extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setFname(fname);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		
		StudentDao dao=new StudentDao();
		Student student2=dao.updateEmployeeById(student);
		if(student2!=null) {
			List<Student>list=dao.getStudentList();
			req.setAttribute("list", list);
			RequestDispatcher reDispatcher=req.getRequestDispatcher("display.jsp");
			reDispatcher.forward(req, resp);
		}
		
	}


}
