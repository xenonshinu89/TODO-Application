package io.anchil.springbootapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.anchil.springbootapp.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	List<Task> findByUserName(String userName);
}
