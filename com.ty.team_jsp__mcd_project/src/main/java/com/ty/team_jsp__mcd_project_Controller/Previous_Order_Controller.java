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
import com.ty.team_jsp__mcd_project_dto.FoodOrder;

@WebServlet("/previous_orders")
public class Previous_Order_Controller  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String email=req.getParameter("email");
	   String password=req.getParameter("pwd");
	   
		FoodOrderDao dao=new FoodOrderDao();
		FoodOrder foodOrder=dao.getFoodOrderByEmail(email);
		System.out.println(foodOrder);
		if(foodOrder!=null) {
			req.setAttribute("list", foodOrder);
			RequestDispatcher dispatcher=req.getRequestDispatcher("show_previous_orders.jsp");
			dispatcher.forward(req, resp);
		}
		
		
		
		
	}

}
