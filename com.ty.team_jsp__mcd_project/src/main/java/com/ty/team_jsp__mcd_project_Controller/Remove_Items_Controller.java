package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.team_jsp__mcd_project_dao.FoodOrderDao;
import com.ty.team_jsp__mcd_project_dao.MenuDao;
import com.ty.team_jsp__mcd_project_dto.Menu;

@WebServlet("/remove_items")
public class Remove_Items_Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		FoodOrderDao dao=new FoodOrderDao();
		boolean b=dao.removeFoodOrder(id);
		if(b) {
//			MenuDao menuDao=new MenuDao();
//			List<Menu> list=menuDao.getMenus();
//			req.setAttribute("list", list);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
		
		
		
	}

}
