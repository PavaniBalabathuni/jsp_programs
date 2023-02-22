package com_ty_jsp_student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_ty_jsp_student.dao.StudentDao;
import com_ty_jsp_student.dto.Student;



@WebServlet("/update")
public class StudentUpdateMain extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		Student student=dao.getById(id);
		if(student !=null) {
			req.setAttribute("id", student);
			RequestDispatcher reDispatcher=req.getRequestDispatcher("update.jsp");
			reDispatcher.forward(req, resp);
		}
	}

}
