package springmvcjconfig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvcjconfig.model.User;
import springmvcjconfig.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public int createUser(User user) {
		return userDao.saveUser(user);
	}
}
