package com.ty.team_jsp__mcd_project_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.team_jsp__mcd_project_dao.MenuDao;
import com.ty.team_jsp__mcd_project_dao.UserDao;
import com.ty.team_jsp__mcd_project_dto.Menu;
import com.ty.team_jsp__mcd_project_dto.User;

@WebServlet("/login")
public class User_Login_Controller extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		UserDao dao = new UserDao();
		User user = dao.getUserBy_Email(email);
		MenuDao menuDao=new MenuDao();
		if (password.equals(user.getPassword())) {
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("name",user.getName() );
			if(user.getRole().equals("Manager")) {
				List<Menu> list=menuDao.getMenus();
				req.setAttribute("list", list);
				req.setAttribute("msg", "Successfully logged in as Manager");
				RequestDispatcher dispatcher=req.getRequestDispatcher("menu.jsp");
				dispatcher.forward(req, resp);
				
			}else if(user.getRole().equals("Staff")){
				List<Menu> list=menuDao.getMenus();
				req.setAttribute("list", list);
				req.setAttribute("msg", "Successfully logged in as Staff");
				RequestDispatcher dispatcher=req.getRequestDispatcher("display_items.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				List<Menu> list=menuDao.getMenus();
				req.setAttribute("email", user.getEmail());
				req.setAttribute("list", list);
				req.setAttribute("msg", "Successfully logged in as Customer");
				RequestDispatcher dispatcher=req.getRequestDispatcher("displaymenu.jsp");
				dispatcher.forward(req, resp);
				
			}
		}				
		else {
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}

}
