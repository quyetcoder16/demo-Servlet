package cm.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm.config.MysqlConnecttion;
import cm.model.Role;

public class RoleRespository {
	public List<Role> getRoles() {
		List<Role> listRole = new ArrayList<Role>();
		Connection connection = MysqlConnecttion.getConnection();

		String query = "select * from role";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setRoleName(resultSet.getString("role_name"));
				role.setDescription(resultSet.getNString("description"));
				listRole.add(role);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listRole;
	}

	public int deleteRoleById(int id) {

		int isDelete = 0;

		Connection connection = MysqlConnecttion.getConnection();

		String query = "delete from role r where r.id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			isDelete = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isDelete;

	}

	public int insertRole(String name, String desc) {
		int isSuccess = 0;

		Connection connection = MysqlConnecttion.getConnection();

		String query = "INSERT INTO role (role_name, description) \r\n" + "VALUES \r\n" + "(?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, desc);

			isSuccess = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isSuccess;
	}
}
