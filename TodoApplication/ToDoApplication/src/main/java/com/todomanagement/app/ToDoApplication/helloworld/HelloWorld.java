package com.todomanagement.app.ToDoApplication.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	
   @GetMapping("/say-hello")
   @ResponseBody
	public String helloWorld() {
		return "Hello how are you";
	}
   @RequestMapping("/say-hello-html")
   @ResponseBody
   public String sayHelloHtml() {
	   StringBuffer sBuffer = new StringBuffer(); 
	   sBuffer.append("<html>");
	   sBuffer.append("<head>");
	   sBuffer.append("<title>Hello World</title>");
	   sBuffer.append("</head>");
	   sBuffer.append("<body>");
	   sBuffer.append("<h1>This is written in stringBuffer");
	   sBuffer.append("</body>");
	   sBuffer.append("</html>");
	//   sBuffer.append("");
	   return sBuffer.toString();
   }
   //@ResponseBody
   @RequestMapping("/say-hello-jsp")
   public String sayHelloJsp() {
	   return "sayHello";
   }
}
