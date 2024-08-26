package com.example.TaskManagementSystem.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.TaskManagementSystem.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
	public List<Task> findByStatus(String status);
	public List<Task> findByPriority(int priority);
	public List<Task> findByDueDate(Date date);
	
	@Query(value="select * from task where title like ?1", nativeQuery = true)
	public List<Task> findByTitleLike(String title);
	
	@Query(value="select * from task where discription like ?1", nativeQuery = true)
	public List<Task> findByDiscriptionLike(String discription);
}
