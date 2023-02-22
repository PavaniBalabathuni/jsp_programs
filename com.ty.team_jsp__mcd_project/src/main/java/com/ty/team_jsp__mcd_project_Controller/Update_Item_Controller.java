package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.team_jsp__mcd_project_dao.ItemsDao;
import com.ty.team_jsp__mcd_project_dto.Items;

@WebServlet("/update_item")
public class Update_Item_Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  int item_id=Integer.parseInt(req.getParameter("id"));
	  ItemsDao dao=new ItemsDao();
	  Items items=dao.getItemById(item_id);
	  if(items!=null) {
		  req.setAttribute("items", items);
		  RequestDispatcher dispatcher=req.getRequestDispatcher("items_editor.jsp");
		  dispatcher.forward(req, resp);
	  }
		
		
		
	}
}
