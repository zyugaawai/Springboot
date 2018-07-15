package wai.springboot.javaconfig;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(SpringConfig.class);
		UserService userService = context.getBean(UserService.class);
		List<User> users = userService.queryUserList();
		
		for(User user : users) {
			System.out.println(user.getUsername());
		}
		
		context.close();
	}

}
