package com.todomanagement.app.ToDoApplication.Login;
import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
		
		@Bean
		public InMemoryUserDetailsManager createcustomuser() { 
			UserDetails userDetails1 = createNewUser("Abhi", "pass");
			UserDetails userDetails2 = createNewUser("Manoj", "pass");
			UserDetails userDetails3 = createNewUser("Shashwat", "pass");
			
				return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3);
		}
		private UserDetails createNewUser(String username, String password) {
			Function<String, String> passwordEncoderFunction = 
					input -> passwordEncoder().encode(input);  
			UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
					.passwordEncoder(passwordEncoderFunction)					
					.username(username)
					.password(password)
					.roles("USER","ADMIN")
					.build();
			return userDetails;
		}
		@Bean
		public PasswordEncoder passwordEncoder() { 
			return new BCryptPasswordEncoder();
		}
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
			http.authorizeHttpRequests(
					auth -> auth.anyRequest().authenticated());
			http.formLogin(withDefaults());
			
			http.csrf().disable();
			http.headers().frameOptions().disable();
			
			return http.build();
		}
		
		
		
		
}
