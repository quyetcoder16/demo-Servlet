package cm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.common.Constant;
import cm.service.RoleService;

@WebServlet(name = "role", urlPatterns = { Constant.URL_ROLE, Constant.URL_ROLE_ADD })
public class RoleController extends HttpServlet {

	private RoleService roleService = new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		switch (urlPath) {
		case Constant.URL_ROLE:
			getAllRole(req, resp);
			break;
		case Constant.URL_ROLE_ADD:
			addRole(req, resp);
			break;

		default:
			break;
		}

	}
	
	

	private void getAllRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles", roleService.getRoles());
		req.getRequestDispatcher("/role.jsp").forward(req, resp);
	}

	private void addRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/role-add.jsp").forward(req, resp);

	}

}
