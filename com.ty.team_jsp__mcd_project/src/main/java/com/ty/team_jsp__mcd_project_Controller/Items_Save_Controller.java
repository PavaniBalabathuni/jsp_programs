package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/additems")
public class Items_Save_Controller extends HttpServlet {
	
static List<Items> list=new ArrayList<>();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		double price = Double.parseDouble(req.getParameter("price"));
		double offer = Double.parseDouble(req.getParameter("offer"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		Items items = new Items();
		items.setName(name);
		items.setDescrption(desc);
		items.setOffer(offer);
		items.setQuantity(quantity);
		items.setPrice(price);
		ItemsDao dao = new ItemsDao();
		Items items2 = dao.addItems(items);
		// MenuDao dao2=new MenuDao();
		if (items2 != null) {
			
			list.add(items2);
			
			req.setAttribute("list", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("f_o_save.jsp");
			dispatcher.forward(req, resp);
//			list.add(items2);
//			List<Items> list = dao.getAllItems();
//			req.setAttribute("list", list);
//			RequestDispatcher dispatcher = req.getRequestDispatcher("f_o_save.jsp");
//			dispatcher.forward(req, resp);
		}

	}

}
