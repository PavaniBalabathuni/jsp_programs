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

@WebServlet("/delete")
public class StudentDeleteMain extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		boolean b=dao.deleteEmployee(id);
		if(b) {
			List<Student>list=dao.getStudentList();
			req.setAttribute("list", list);
			RequestDispatcher reqDispatcher=req.getRequestDispatcher("display.jsp");
			reqDispatcher.forward(req, resp);
		}
	}
	

}
