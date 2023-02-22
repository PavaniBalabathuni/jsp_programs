package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.team_jsp__mcd_project_dao.ItemsDao;
import com.ty.team_jsp__mcd_project_dao.MenuDao;
import com.ty.team_jsp__mcd_project_dto.Items;
import com.ty.team_jsp__mcd_project_dto.Menu;

@WebServlet("/add_items")
public class AddItems extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Menu> list=new MenuDao().getMenus();
		req.setAttribute("list", list);
		 RequestDispatcher dispatcher=req.getRequestDispatcher("display_items.jsp");
		 dispatcher.forward(req, resp);
	}
}
