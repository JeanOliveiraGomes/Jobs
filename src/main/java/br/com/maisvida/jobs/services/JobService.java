package br.com.maisvida.jobs.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maisvida.jobs.converters.JobConverter;
import br.com.maisvida.jobs.dtos.JobDTO;
import br.com.maisvida.jobs.entidades.Job;
import br.com.maisvida.jobs.entidades.Task;
import br.com.maisvida.jobs.repository.JobRepository;
import br.com.maisvida.jobs.repository.TaskRepository;


@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRep;
	
	@Autowired
	private TaskRepository taskRep;
	
	public JobDTO salvar(JobDTO jobDTO) {
		 setarDataCriacao(jobDTO);
		 Job entidade = jobRep.save(JobConverter.paraEntidade(jobDTO));
		 saveTask(jobDTO, entidade);		
		 return JobConverter.paraDTO(entidade);
	}
	
	public List<JobDTO> listarTodosOsJobs(){
		List<Job> jobs = (List<Job>) jobRep.findAll();
		List<JobDTO> jobsDTO = new ArrayList<JobDTO>();
		for (Job job : jobs) {
			jobsDTO.add(JobConverter.paraDTO(job));
		}
		
		return jobsDTO;
		
	}
	
	public JobDTO atualizarJob(JobDTO jobDTO) {
		setarDataCriacao(jobDTO);
		Job entidade = jobRep.save(JobConverter.paraEntidade(jobDTO));
		saveTask(jobDTO, entidade);
		return JobConverter.paraDTO(entidade);
		
	}
	
	public JobDTO deletarJob(JobDTO jobDTO) {
		jobRep.delete(jobRep.findByName(jobDTO.getName()));
		return jobDTO;
	}
	
	private void saveTask(JobDTO jobDTO, Job entidade) {
		 List<Task> taskEntite = jobDTO.getTasks();
		 
		 for (Task task : taskEntite) {
			task.setJob(entidade);
			taskRep.save(task);
		}
	}
	
	private void setarDataCriacao(JobDTO jobDTO) {
		if (!jobDTO.getTasks().isEmpty()) {
			for (Task taskDTO : jobDTO.getTasks()) {
				if (taskDTO.getCreatedAt() == null) {
					taskDTO.setCreatedAt(LocalDate.now());
				}
			}
		}
	}
}
