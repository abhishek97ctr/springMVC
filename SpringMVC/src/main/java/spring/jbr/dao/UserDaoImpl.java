package spring.jbr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.jbr.model.User;
import spring.jbr.model.login;

public class UserDaoImpl implements Userdao
{
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTamplate;
	public void Register (User user)
	{
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		
		jdbcTamplate.update(sql, new Object[] {user.getUsername(),user.getPassword(),user.getFirstname(),
				user.getLastname(),user.getEmail(),user.getAddress(),user.getPhone()});
	}	public User validateUser(login Login) 
	{
		String sql = "select * from users where username='" + Login.getUsername() + "' and password='" + Login.getPassword()
		+ "'";
		 List<User> users =jdbcTamplate.query(sql, new UserMapper());

		return users.size() > 0 ? users.get(0) : null;
	}
	public int register(User user) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
class UserMapper implements RowMapper<User> {

	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();

	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    user.setFirstname(rs.getString("firstname"));
	    user.setLastname(rs.getString("lastname"));
	    user.setEmail(rs.getString("email"));
	    user.setAddress(rs.getString("address"));
	    user.setPhone(rs.getInt("phone"));

	    return user;
	  }
	}
