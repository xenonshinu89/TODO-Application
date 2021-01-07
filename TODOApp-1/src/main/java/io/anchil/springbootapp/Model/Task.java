package io.anchil.springbootapp.Model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	private String taskName;
	private String taskDescription;
	private Date taskDate;
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Task( int id,String userName, String taskName, String taskDescription, Date taskDate) {
		super();
		this.id=id;
		this.userName = userName;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskDate = taskDate;
	}
	
	public Task(  String taskName, String taskDescription, Date taskDate) {
		super();
		
		this.userName = null;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskDate = taskDate;
	}
	
	public Task( String userName, String taskName, String taskDescription, Date taskDate) {
		super();
		
		this.userName = userName;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskDate = taskDate;
	}



	public Task(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Date getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}
	
	

}
