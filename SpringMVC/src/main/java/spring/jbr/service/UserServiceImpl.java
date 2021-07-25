package spring.jbr.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.jbr.dao.Userdao;
import spring.jbr.model.User;
import spring.jbr.model.login;


public class UserServiceImpl implements UserService
{
	@Autowired
	public Userdao userDao;
	public int register(User user)
	{
		return userDao.register(user);
		
	}
	public User validateUser(login login)
	{
		return userDao.validateUser(login);
		
	}
	public int register(Userdao user) {
		// TODO Auto-generated method stub
		return 0;
	}
}





