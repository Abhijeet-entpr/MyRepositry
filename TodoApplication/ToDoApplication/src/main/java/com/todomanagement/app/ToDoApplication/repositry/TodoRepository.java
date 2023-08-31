package com.todomanagement.app.ToDoApplication.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todomanagement.app.ToDoApplication.ToDo.ToDo;

public interface TodoRepository extends JpaRepository<ToDo, Long> {
	
	public List<ToDo> findByUsername(String username);
}
