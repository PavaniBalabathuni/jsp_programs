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
import com.ty.team_jsp__mcd_project_dao.FoodOrderDao;
import com.ty.team_jsp__mcd_project_dao.ItemsDao;
import com.ty.team_jsp__mcd_project_dto.FoodOrder;
import com.ty.team_jsp__mcd_project_dto.Items;

@WebServlet("/food_order")
public class FoodOrder_Controller extends HttpServlet {
	 List<Items> items = new ArrayList<>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));

//		int count = Integer.parseInt(req.getParameter("count"));
		ItemsDao dao = new ItemsDao();
		List<Items> list1=Items_Save_Controller.list;
//		while (count > 0) {
//			int fix = Integer.parseInt(req.getParameter("order_id"));
//			Items list = dao.getItemById(fix);
//
//			items.add(list);
//			count--;
//		}
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setCustomer_name(name);
		foodOrder.setEmail(email);
		foodOrder.setAddress(address);
		foodOrder.setPhone(phone);
		foodOrder.setList(list1);

		FoodOrderDao dao1 = new FoodOrderDao();
		FoodOrder foodOrder2 = dao1.saveOrder(foodOrder);
		req.setAttribute("food", foodOrder2);
		RequestDispatcher dispatcher = req.getRequestDispatcher("print.jsp");
		dispatcher.forward(req, resp);
		Items_Save_Controller.list.clear();
	}

}
