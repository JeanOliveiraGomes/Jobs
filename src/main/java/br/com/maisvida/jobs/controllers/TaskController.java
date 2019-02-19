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

import br.com.maisvida.jobs.dtos.TaskDTO;
import br.com.maisvida.jobs.repository.TaskRepository;
import br.com.maisvida.jobs.services.TaskService;

@Controller
@RequestMapping(value = "task")
public class TaskController {
	@Autowired
	private TaskService taskServ;
	
	@PostMapping
	public ResponseEntity<TaskDTO> salvarTask(@RequestBody TaskDTO dto){
		
		TaskDTO taskDTO = taskServ.salvar(dto);
		return ResponseEntity.ok(taskDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> buscarTodos(){
		
		List<TaskDTO> ListTaskDTO = taskServ.listarTodos();
		return ResponseEntity.ok(ListTaskDTO);
	}
	
	@PutMapping
	public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO dto){
		
		TaskDTO taskDTO = taskServ.update(dto);
		return ResponseEntity.ok(taskDTO);
	}
	
	@DeleteMapping
	public ResponseEntity<TaskDTO> deletarJob(@RequestBody TaskDTO dto){
		
		TaskDTO taskDTO = taskServ.deletar(dto);
		return ResponseEntity.ok(taskDTO);
	}
}
