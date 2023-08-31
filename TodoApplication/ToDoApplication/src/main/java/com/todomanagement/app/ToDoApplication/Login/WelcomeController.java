package com.todomanagement.app.ToDoApplication.Login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
	
//	@Autowired
//	private AuthenticationService authenticate;
//	
//	public LoginController(AuthenticationService authenticate) {  
//		this.authenticate=authenticate;
//	}
		
	//private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/")
	public String login(ModelMap model) {  
		//logger.info("Request param is "+name);
		//modelMap.put("name", name);
		model.put("name", getLoggedInUsername());
		return "welcome";
	}
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String loginToWelcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		
//		if(authenticate.authenticate(name, password)) {  
//			model.put("name", name);
//			model.put("password", password);
//			return "welcome";
//		}
//		model.put("errormsg", "Invalid Credentials! please try again");
//		return "loginPage";
//	}

private String getLoggedInUsername() {
	// TODO Auto-generated method stub
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
}
}
