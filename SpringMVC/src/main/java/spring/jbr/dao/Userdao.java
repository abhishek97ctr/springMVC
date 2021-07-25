package spring.jbr.dao;

import spring.jbr.model.User;
import spring.jbr.model.login;

public interface Userdao
{
	int register(User user);
	User validateUser(login Login);
}
