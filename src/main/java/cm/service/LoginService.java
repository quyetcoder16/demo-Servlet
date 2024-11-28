package cm.service;

import java.util.List;

import cm.model.User;
import cm.respository.UserRespository;

public class LoginService {

	private UserRespository userRespository = new UserRespository();

	public boolean checkLogin(String userName, String password) {
		List<User> lisUsers = userRespository.getUserByUsernameAndPassWord(userName, password);

		return lisUsers.size() > 0;
	}
}
