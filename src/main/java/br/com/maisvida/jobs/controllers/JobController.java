package br.com.maisvida.jobs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.maisvida.jobs.converters.JobConverter;
import br.com.maisvida.jobs.dtos.JobDTO;
import br.com.maisvida.jobs.entidades.Job;
import br.com.maisvida.jobs.repository.JobRepository;
import br.com.maisvida.jobs.services.JobService;

@Controller
@RequestMapping(value = "job")
public class JobController {

	@Autowired
	private JobService jobServ;
	
	
    @PostMapping
    public ResponseEntity<JobDTO> salvarJob(@RequestBody JobDTO jobDTO){
        
    	JobDTO entity = jobServ.salvar(jobDTO); 
    	return ResponseEntity.ok(entity);
    }
    @GetMapping
    public ResponseEntity<List<JobDTO>> listarTodos(){
        List<JobDTO> jobs = jobServ.listarTodosOsJobs();
        
        return ResponseEntity.ok(jobs);
    }
    
    @PutMapping
    public ResponseEntity<JobDTO> updateJob(@RequestBody JobDTO jobDTO){
    	return ResponseEntity.ok(jobServ.atualizarJob(jobDTO));
    }
    
    @DeleteMapping
    public ResponseEntity<JobDTO> deletarJob(@RequestBody JobDTO jobDTO){
    	return ResponseEntity.ok(jobServ.deletarJob(jobDTO));
    }

}
