package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.team_jsp__mcd_project_dao.MenuDao;
import com.ty.team_jsp__mcd_project_dto.Menu;

@WebServlet("/update")
public class Menu_Update extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	MenuDao dao=new MenuDao();
	Menu menu=dao.getMenuById(id);
	HttpSession httpSession = req.getSession();
	String name = (String) httpSession.getAttribute("name");
	if(name!=null) {
		req.setAttribute("menu", menu);
		RequestDispatcher dispatcher=req.getRequestDispatcher("editor.jsp");
		dispatcher.forward(req, resp);
	}
	else {
		req.setAttribute("msg", "if you want to update first log in first");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}
		
		
		
	}

}
