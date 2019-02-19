package br.com.maisvida.jobs.dtos;

import java.util.List;

import br.com.maisvida.jobs.entidades.Job;
import br.com.maisvida.jobs.entidades.Task;

public class JobDTO {
	
	Long id;
	String name;
	Boolean active;
	List<Job> parentJob;
	List<Task> tasks;
	
	public JobDTO(){}
	public JobDTO(Long id, String name, Boolean active, List<Job> parentJob, List<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.parentJob = parentJob;
		this.tasks = tasks;
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
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<Job> getParentJob() {
		return parentJob;
	}
	public void setParentJob(List<Job> parentJob) {
		this.parentJob = parentJob;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}
