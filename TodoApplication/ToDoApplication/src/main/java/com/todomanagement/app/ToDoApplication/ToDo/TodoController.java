package com.todomanagement.app.ToDoApplication.ToDo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todomanagement.app.ToDoApplication.ToDo.ToDo;
import com.todomanagement.app.ToDoApplication.ToDo.TodoService;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@RequestMapping(value = "/todos",method = RequestMethod.GET)
	public String showTodos(ModelMap model) {  
			List<ToDo> todos =	service.findByUsername(getLoggedInUsername(model));
		model.put("todos", todos);
		return "listTodos"; 
	}
	
    @GetMapping("/add-todo")
    public String goToAddTodo(ModelMap model) { 
		String username = getLoggedInUsername(model);
    	ToDo toDo = new ToDo(0, null, null, null, false);
    	model.addAttribute("todo", toDo);
    	return "addTodo";
    }
	@PostMapping("/add-todo")
	public String createTodo(ModelMap model,@Valid ToDo todo ,BindingResult result) {
		model.addAttribute("todo", todo);
		if(result.hasErrors()) {
			return "addTodo";
		}
			String username = getLoggedInUsername(model);
			service.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:/todos";
		
	}
	@GetMapping("/delete-todo")
	public String deletetodo(long id) { 
		service.deleteById(id);
		return "redirect:/todos";
	}

	@GetMapping("/update-todo")
	public String updatetodopage(@RequestParam long id, ModelMap model) { 
		ToDo toDo = service.findById(id);
		model.addAttribute("todo", toDo);
		return "addTodo";
	}
	
	@PostMapping("/update-todo")
	public String updateTodo(ModelMap model,@Valid ToDo todo ,BindingResult result) {
		model.addAttribute("todo", todo);
		if(result.hasErrors()) {
			return "addTodo";
		}
			String username = getLoggedInUsername(model);
			service.updateTodo(todo);
			return "redirect:/todos";
	}

	
	private String getLoggedInUsername(ModelMap model) {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
