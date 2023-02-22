package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.team_jsp__mcd_project_dao.MenuDao;
import com.ty.team_jsp__mcd_project_dto.Menu;

@WebServlet("/editor")
public class Menu_editor  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String desc=req.getParameter("desc");
		double price=Double.parseDouble(req.getParameter("price"));
		double offer=Double.parseDouble(req.getParameter("offer"));
		
		Menu menu=new Menu();
		menu.setId(id);
		menu.setName(name);
		menu.setDescription(desc);
		menu.setOffer(offer);
		menu.setPrice(price);
		MenuDao dao=new MenuDao();
	Menu menu2=dao.updateMenu(menu);
	if(menu2!=null) {
		List<Menu> list=dao.getMenus();
    	req.setAttribute("list", list);
    	RequestDispatcher dispatcher=req.getRequestDispatcher("menu.jsp");
    	dispatcher.forward(req, resp);
		
		
	}
	}

}
