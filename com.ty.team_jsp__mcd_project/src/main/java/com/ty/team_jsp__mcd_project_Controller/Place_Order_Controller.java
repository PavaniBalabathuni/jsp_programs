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
import com.ty.team_jsp__mcd_project_dto.Items;

@WebServlet("/place_order")
public class Place_Order_Controller extends HttpServlet {
	static List<Items> list = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		ItemsDao dao = new ItemsDao();
		Items items = dao.getItemById(id);

		list.add(items);
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("f_o_save.jsp");
		dispatcher.forward(req, resp);

	}

}
