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



@WebServlet("/login")
public class StudentLoginMain extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		StudentDao dao= new StudentDao();
		Student student=dao.loginStudent(email);
		List<Student> list=dao.getStudentList();
		if(student.getPassword().equals(password)) {
			
			req.setAttribute("list", list);
			RequestDispatcher reDispatcher=req.getRequestDispatcher("display.jsp");
			reDispatcher.forward(req, resp);
			
		}
		else {
			req.setAttribute("msg", "Invalid password...please check once!!!!");
			RequestDispatcher reqDispatcher=req.getRequestDispatcher("login.jsp");
			reqDispatcher.include(req, resp);
			
		}
	}

}
