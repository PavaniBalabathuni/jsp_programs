package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.team_jsp__mcd_project_dao.MenuDao;
import com.ty.team_jsp__mcd_project_dto.Menu;

@WebServlet("/order")
public class Items_Order  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MenuDao dao=new MenuDao();
		Menu menu=dao.getMenuById(id);
		if(menu!=null) {
			req.setAttribute("menu", menu);
			RequestDispatcher dispatcher=req.getRequestDispatcher("additems.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
