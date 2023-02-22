package com_ty_jsp_student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_ty_jsp_student.dao.StudentDao;
import com_ty_jsp_student.dto.Student;



@WebServlet("/signup")
public class StudentSignupMain extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		
		Student student=new Student();
		student.setName(name);
		student.setFname(fname);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		ServletContext context=getServletContext();
		Double fee=Double.parseDouble(context.getInitParameter("fee"));
		student.setFee(fee);
		StudentDao dao=new StudentDao();
		Student stdSave=dao.saveStudent(student);
		
		
		if(stdSave != null) {
			RequestDispatcher reqDispatcher=req.getRequestDispatcher("login.jsp");
			reqDispatcher.forward(req, resp);
		}

	}

}
