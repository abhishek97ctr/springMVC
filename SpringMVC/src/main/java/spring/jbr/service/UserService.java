package spring.jbr.service;

import spring.jbr.dao.Userdao;
import spring.jbr.model.User;
import spring.jbr.model.login;

public interface UserService {
	int register(Userdao user);
	User validateUser(login login);

}
