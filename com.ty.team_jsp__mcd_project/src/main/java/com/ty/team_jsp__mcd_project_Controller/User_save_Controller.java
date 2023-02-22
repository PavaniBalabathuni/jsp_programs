package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.StringHelper;

import com.ty.team_jsp__mcd_project_dao.UserDao;
import com.ty.team_jsp__mcd_project_dto.User;

@WebServlet("/save")
public class User_save_Controller  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("pwd");
	String address=req.getParameter("address");
	String role=req.getParameter("role");
	long phone=Long.parseLong(req.getParameter("phone"));
	User user=new User();
	user.setName(name);
	user.setAddress(address);
	user.setEmail(email);
	user.setPassword(password);
	user.setPhone(phone);
	user.setRole(role);
	UserDao dao=new UserDao();
	User user2=dao.saveUser(user);
	if(user2!=null) {
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}
	else {
		req.setAttribute("msg", "Email already exist");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
		
	}
	}

}
