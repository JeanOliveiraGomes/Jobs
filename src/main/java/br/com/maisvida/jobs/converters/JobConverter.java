package br.com.maisvida.jobs.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.maisvida.jobs.dtos.JobDTO;
import br.com.maisvida.jobs.dtos.TaskDTO;
import br.com.maisvida.jobs.entidades.Job;
import br.com.maisvida.jobs.entidades.Task;
import br.com.maisvida.jobs.services.JobService;
import br.com.maisvida.jobs.services.TaskService;

public class JobConverter {

	public static Job paraEntidade(JobDTO dto) {
		Job entidade = new Job(
				dto.getId(),
				dto.getName(), 
				dto.getActive(),
				dto.getParentJob(),
				dto.getTasks());
		return entidade;
	}
	
	public static JobDTO paraDTO(Job entidade) {
		JobDTO dto = new JobDTO(entidade.getId(),
				entidade.getName(), 
				entidade.getActive(), 
				entidade.getParentJob(),
				entidade.getTasks());
		return dto;
	}
	
}
