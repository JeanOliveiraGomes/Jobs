package br.com.maisvida.jobs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.maisvida.jobs.dtos.JobDTO;
import br.com.maisvida.jobs.entidades.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
	
	Job findByName(String name);
}
