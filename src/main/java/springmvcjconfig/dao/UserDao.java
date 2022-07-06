package springmvcjconfig.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvcjconfig.model.User;

@Repository
public class UserDao {

	@Autowired
	   private SessionFactory sessionFactory;
	
	@Transactional
	public int saveUser(User user) {
		int id = (Integer) sessionFactory.getCurrentSession().save(user);
		return id;
	}
}
