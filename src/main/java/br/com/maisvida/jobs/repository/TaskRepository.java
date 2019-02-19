package br.com.maisvida.jobs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.maisvida.jobs.dtos.TaskDTO;
import br.com.maisvida.jobs.entidades.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
	
	List<TaskDTO> findByJobId(Long id);

}
