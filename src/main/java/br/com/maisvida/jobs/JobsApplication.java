package br.com.maisvida.jobs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.maisvida.jobs.dtos.TaskDTO;
import br.com.maisvida.jobs.entidades.Task;
import br.com.maisvida.jobs.services.TaskService;

@SpringBootApplication
public class JobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobsApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(TaskService taskService) {
        return args -> {
        	popularTask(taskService);
        };
    }
	
	private void popularTask(TaskService taskService){
		for (int i = 0; i < 30; i++) {
			TaskDTO task = new TaskDTO();
			task.setCompleted(false);
			task.setName("Task"+i);
			task.setWeight(i);
			taskService.salvar(task);
		}
	}

}
