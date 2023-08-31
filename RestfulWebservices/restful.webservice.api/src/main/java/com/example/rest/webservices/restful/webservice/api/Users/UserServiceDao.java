package com.example.rest.webservices.restful.webservice.api.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
@Component
public class UserServiceDao {
		
	 static long usercount;
	 
	 static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(++usercount,"Abhi",LocalDate.now().minusYears(30)));
		users.add(new User(++usercount,"Shashwat",LocalDate.now().minusYears(25)));
		users.add(new User(++usercount,"manoj",LocalDate.now().minusYears(20)));
		users.add(new User(++usercount,"manoj",LocalDate.now().minusYears(20)));
		users.add(new User(++usercount,"manoj",LocalDate.now().minusYears(20)));
	}
	
	public List<User> retrieveUsers(){
		return users;
	}
	
	public User retreiveUser(long userId) {
		Predicate<User> predicate = user -> user.getUserId()==userId; 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User addUser(User user) {
		user.setUserId(++usercount);
		users.add(user);
		return user;
	}

	public void deleteUser(long userId) {
		Predicate<User> predicate = user -> user.getUserId()==userId; 
		users.removeIf(predicate);
	}
	

}
