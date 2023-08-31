package com.todomanagement.app.ToDoApplication.Login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
			
		public boolean authenticate(String name, String password) {
			boolean isValidname = name.equalsIgnoreCase("Abhi");
			boolean isValidpassword = password.equalsIgnoreCase("pass");
			return isValidname && isValidpassword;
		}
}
