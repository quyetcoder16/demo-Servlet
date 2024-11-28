package cm.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cm.common.Constant;
import cm.payload.ResponseData;
import cm.service.RoleService;

@WebServlet(name = "roleApi", urlPatterns = { Constant.URL_ROLE_API_DELETE, Constant.URL_ROLE_API_ADD })
public class RoleApi extends HttpServlet {

	private RoleService roleService = new RoleService();
	private Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String urlPath = req.getServletPath();
		switch (urlPath) {
		case Constant.URL_ROLE_API_ADD:
			addRole(req, resp);
			break;
		case Constant.URL_ROLE_API_DELETE:
			deleteRole(req, resp);
			break;
		default:
			break;
		}
	}

	private void addRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String roleName = req.getParameter("name");
		String desc = req.getParameter("desc");

		boolean isSuccess = roleService.insertRole(roleName, desc);

		ResponseData data = new ResponseData();
		data.setSuccess(isSuccess);
		data.setDescription("");
		data.setData("");

		String json = gson.toJson(data);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out;

		out = resp.getWriter();
		out.print(json);
		out.flush();

	}

	private void deleteRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		boolean isSuccess = roleService.deleteRoleById(id);

		ResponseData data = new ResponseData();
		data.setSuccess(isSuccess);
		data.setDescription("");
		data.setData("");

		String json = gson.toJson(data);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out;

		out = resp.getWriter();
		out.print(json);
		out.flush();

	}
}
