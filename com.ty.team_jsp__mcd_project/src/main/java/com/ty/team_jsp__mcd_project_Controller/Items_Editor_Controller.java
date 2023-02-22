package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.IconView;

import com.ty.team_jsp__mcd_project_dao.ItemsDao;
import com.ty.team_jsp__mcd_project_dto.Items;

@WebServlet("/items_editor")
public class Items_Editor_Controller  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   int id=Integer.parseInt(req.getParameter("id"));
	   String name=req.getParameter("name");
	   String discription=req.getParameter("desc");
	   double price=Double.parseDouble(req.getParameter("price"));
	   double offer=Double.parseDouble(req.getParameter("offer"));
		
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		ItemsDao dao=new ItemsDao();
		Items items=new Items();
		items.setId(id);
		items.setName(name);
		items.setOffer(offer);
		items.setPrice(price);
		items.setDescrption(discription);
		items.setQuantity(quantity);
		
		
		Items items1 = null;
		for (Items item : Items_Save_Controller.list) {
			if (id == item.getId()) {
				items1 = item;
			}
		}
		Items_Save_Controller.list.remove(items1);
		Items items2=dao.update_Item(items);
		if(items2!=null) {
			
			
			Items_Save_Controller.list.add(items2);
			req.setAttribute("list", Items_Save_Controller.list);
			
			
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("f_o_save.jsp");
			dispatcher.forward(req, resp);
			
		}
		
	   
	}
}
