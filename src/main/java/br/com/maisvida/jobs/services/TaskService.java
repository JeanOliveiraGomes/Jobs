package br.com.maisvida.jobs.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.LocalDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.maisvida.jobs.converters.TaskConverter;
import br.com.maisvida.jobs.dtos.TaskDTO;
import br.com.maisvida.jobs.entidades.Task;
import br.com.maisvida.jobs.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRep;
	
	
	public TaskDTO salvar(TaskDTO taskDTO) {
		taskDTO.setCreatedAt(LocalDate.now());
		Task entidade = taskRep.save(TaskConverter.paraEntidade(taskDTO));
		return TaskConverter.paraDTO(entidade);
	}
	
	
	public TaskDTO update(TaskDTO dto) {
		Task entidade = taskRep.save(TaskConverter.paraEntidade(dto));
		return TaskConverter.paraDTO(entidade);
	}
	
	public TaskDTO deletar(TaskDTO dto) {
		taskRep.delete(TaskConverter.paraEntidade(dto));
		return dto;
	}
	
	public List<TaskDTO> listarTodos(){
		Iterable<Task> tasks = taskRep.findAll();
		List<TaskDTO> tasksDTO = new ArrayList<TaskDTO>();
		for (Task task : tasks) {
			tasksDTO.add(TaskConverter.paraDTO(task));
		}
		return tasksDTO;
		
	}
	
	
	public List<TaskDTO> findByJobId(Long id){
		return taskRep.findByJobId(id);
	}
	
}
