package cm.service;

import java.util.List;

import cm.model.Role;
import cm.respository.RoleRespository;

public class RoleService {
	private RoleRespository roleRespository = new RoleRespository();

	public List<Role> getRoles() {
		List<Role> listRoles = roleRespository.getRoles();

		return listRoles;

	}

	public boolean deleteRoleById(int id) {
		return roleRespository.deleteRoleById(id) > 0;
	}

	public boolean insertRole(String name, String desc) {
		return roleRespository.insertRole(name, desc) > 0;
	}
}
