package br.com.maisvida.jobs.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task implements Serializable{
	
	@Id
	@GeneratedValue
	Long id;
	String name;
	Integer weight;
	Boolean completed;
	LocalDate createdAt;
	
	@ManyToOne
	@JsonIgnore
	Job job;
    
    
    public Task() {
    }
	public Task(Long id, String name, Integer weight, Boolean completed, Job job, LocalDate createdAt) {
		super();
		this.id= id;
		this.name = name;
		this.weight = weight;
		this.completed = completed;
		this.job = job;
		this.createdAt = createdAt;
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
