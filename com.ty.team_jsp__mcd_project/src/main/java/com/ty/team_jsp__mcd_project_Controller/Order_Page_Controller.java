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

@WebServlet("/order_page")
public class Order_Page_Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      MenuDao dao=new MenuDao();
      List<Menu> list=dao.getMenus();
      if(list!=null) {
    	  req.setAttribute("list", list);
    	  RequestDispatcher dispatcher=req.getRequestDispatcher("display_items.jsp");
    	  dispatcher.forward(req, resp);
      }
		
		
		
		
	}

}
