package com.example.TaskManagementSystem;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagementSystem.entity.Task;
import com.example.TaskManagementSystem.repository.TaskRepository;

@RestController
public class TaskController {
	
	@Autowired
	TaskRepository taskRepo;
	
	@PostMapping("/tasks")
	public Task createTask(@RequestBody Task task)
	{
		return taskRepo.save(task);
	}
	
	@GetMapping("/tasks")
	public List<Task> getTask()
	{
		return (List<Task>) taskRepo.findAll();
	}
	
	@PutMapping("/tasks")
	public Task updateTask(@RequestBody Task task)
	{
		return taskRepo.save(task);
	}
	
//	@PutMapping("/tasks/{taskId}")
//	public Task updateTask(@PathVariable int taskId)
//	{
//		Task task=new Task();
//		task.setId(taskId);
//		return taskRepo.save(task);
//	}
	
	@DeleteMapping("/tasks/{taskId}")
	public String deleteTask(@PathVariable int taskId)
	{
		try {
			taskRepo.deleteById(taskId);
			return "OK";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "NOT_OK";
		}
	}
	
	@GetMapping("/tasks/findByStatus/{status}")
	public List<Task> filterTasksByStatus(@PathVariable String status)
	{
		return taskRepo.findByStatus(status);
	}
	
	@GetMapping("/tasks/findByPriority/{priority}")
	public List<Task> filterTasksByPriority(@PathVariable int priority)
	{
		return taskRepo.findByPriority(priority);
	}
	
	@GetMapping("/tasks/findByDuedate/{date}")
	public List<Task> filterTasksByStatus(@PathVariable Date date)
	{
		return taskRepo.findByDueDate(date);
	}
	
	@GetMapping("/tasks/search/{title}")
	public List<Task> searchTaskByTitle(@PathVariable String title)
	{
		return taskRepo.findByTitleLike("%" + title + "%");
	}
	
	@GetMapping("/tasks/search/{discription}")
	public List<Task> searchTaskByDiscription(@PathVariable String discription)
	{
		return taskRepo.findByDiscriptionLike("%" + discription + "%");
	}
}
