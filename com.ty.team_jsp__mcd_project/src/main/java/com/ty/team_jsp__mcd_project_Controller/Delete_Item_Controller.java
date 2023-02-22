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
import com.ty.team_jsp__mcd_project_dto.Items;

@WebServlet("/delete_item")
public class Delete_Item_Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int item_id = Integer.parseInt(req.getParameter("id"));
		Items items1 = null;
		for (Items items : Items_Save_Controller.list) {
			if (item_id == items.getId()) {
				items1 = items;
			}
		}
		
		ItemsDao dao=new ItemsDao();
		dao.delete_item(item_id);

		Items_Save_Controller.list.remove(items1);
		List<Items> list = Items_Save_Controller.list;
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("f_o_save.jsp");
		dispatcher.forward(req, resp);

	}

}
