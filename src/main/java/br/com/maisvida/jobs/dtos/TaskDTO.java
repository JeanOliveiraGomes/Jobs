package br.com.maisvida.jobs.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.maisvida.jobs.entidades.Job;

public class TaskDTO {
	
	Long id;
	String name;
	Integer weight;
	Boolean completed;
	Job job;
	LocalDate createdAt;
	
	
	public TaskDTO() {}
	public TaskDTO(Long id, String name, Integer weight, Boolean completed, Job job, LocalDate localDate) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.completed = completed;
		this.job = job;
		this.createdAt = localDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
