package wai.springboot.javaconfig;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	public List<User> queryUserList() {
		List<User> users = new ArrayList<User>();
		
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setPassword("password " + i);
			user.setUsername("username " + i);
			users.add(user);
		}
		
		return users;
	}
}
