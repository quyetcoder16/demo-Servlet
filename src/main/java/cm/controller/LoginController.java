package cm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.service.LoginService;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginController extends HttpServlet {

	private LoginService loginService = new LoginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("./login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		boolean isLogin = loginService.checkLogin(userName, password);

		System.out.println(isLogin);

		req.getRequestDispatcher("./login.jsp").forward(req, resp);
	}
}
