package com.example.TaskManagementSystem.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String title;
	String discription;
	String status;
	int priority;
	@JsonFormat(pattern="dd-MM-yyyy")
	Date dueDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	Date createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	User user;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String title, String discription, String status, int priority, Date dueDate, Date createdAt,
			User user) {
		super();
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.status = status;
		this.priority = priority;
		this.dueDate = dueDate;
		this.createdAt = createdAt;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
} 
