package io.anchil.springbootapp.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.anchil.springbootapp.Model.Task;
import io.anchil.springbootapp.Repository.TaskRepository;


@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	
	public List<Task> getAllTasks()
	{
		return taskRepository.findAll();
	}
	
	public List<Task> getTasksByUser(String user) {
		return taskRepository.findByUserName(user);
	}

	
	public Optional<Task> getTaskById(int id) {
		return taskRepository.findById(id);
	}

	
	public void updateTask(Task task) {
		taskRepository.save(task);
	}

	
	public void addTask(String userName, String taskname,String taskDescription, Date targetDate) {
		taskRepository.save(new Task(userName,taskname,taskDescription,targetDate));
	}

	
	public void deleteTask(int id) {
		Optional<Task> task = taskRepository.findById(id);
		if (task.isPresent()) {
			taskRepository.delete(task.get());
		}
	}

	
	public void saveTask(Task task) {
		taskRepository.save(task);
	}
}
