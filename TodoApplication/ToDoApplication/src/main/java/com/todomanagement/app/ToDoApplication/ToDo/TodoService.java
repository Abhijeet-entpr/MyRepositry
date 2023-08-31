package com.todomanagement.app.ToDoApplication.ToDo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Service

public class TodoService {
	
	public static List<ToDo> todos = new ArrayList<ToDo>();
	public static int todocount;
	static {
		todos.add(new ToDo(++todocount, "Manoj", "Learn AWS",LocalDate.now(), false));
		todos.add(new ToDo(++todocount, "Shashwat", "Learn Azure",LocalDate.now(), false));
		todos.add(new ToDo(++todocount, "Manoj", "Learn Ajax",LocalDate.now(), false));
		todos.add(new ToDo(++todocount, "Ranga", "Learn Jenkins",LocalDate.now(), false));			
	}
	
	public List<ToDo> findByUsername(String username){ 
		Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList()
		 ;
	}

	public void addTodo(String name, String description, LocalDate targetDate, boolean done) {
		todos.add( new ToDo(++todocount, name, description, targetDate, done));
	}
	public void deleteById(@RequestParam long id) {
		// TODO Auto-generated method stub
		Predicate<? super ToDo> predicate = todo -> todo.getId()==id ;
		todos.removeIf(predicate);
	}

	public ToDo findById(long id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId()==id ;
		ToDo toDo = todos.stream().filter(predicate).findFirst().get();
		return toDo;
	}
	public void updateTodo(@Valid ToDo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
	}
	
	
	
	
}
