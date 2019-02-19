package br.com.maisvida.jobs.converters;

import br.com.maisvida.jobs.dtos.TaskDTO;
import br.com.maisvida.jobs.entidades.Task;

public class TaskConverter {
	
	public static Task paraEntidade(TaskDTO dto) {
		
		Task task = new Task(
				dto.getId(),
				dto.getName(),
				dto.getWeight(),
				dto.getCompleted(),
				dto.getJob(), dto.getCreatedAt());
		
		return task;
	}
	
	public static TaskDTO paraDTO(Task entidade) {
		TaskDTO dto = new TaskDTO(
				entidade.getId(), 
				entidade.getName(), 
				entidade.getWeight(), 
				entidade.getCompleted(),
				entidade.getJob(), entidade.getCreatedAt());
		
		return dto;
	}

}
