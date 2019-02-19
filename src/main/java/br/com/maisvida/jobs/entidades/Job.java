package br.com.maisvida.jobs.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Job implements Serializable{
	
	@Id
	@GeneratedValue
	Long id;
	@Column(unique=true)
	String name;
	Boolean active;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "parentJob")
	List<Job> parentJob;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="job")
	@JsonIgnore
	List<Task> tasks;
	
	

	public Job() {};
	public Job(Long id, String name, Boolean active, List<Job> parentJob, List<Task> tasks) {
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
