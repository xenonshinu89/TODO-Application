package io.anchil.springbootapp.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.anchil.springbootapp.Model.Task;
import io.anchil.springbootapp.Service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping(value = "/listTasks")
	public ModelAndView showTasks() {
		ModelAndView model = new ModelAndView();
		String name = getLoggedInUserName();
		model.addObject("tasks", taskService.getTasksByUser(name));
		model.addObject("name",name);
		model.setViewName("listTasks");
		return model;
	}

	 @GetMapping(value = "/addTask") 
	 public ModelAndView showAddTaskPage() { 
		 
		 ModelAndView model = new ModelAndView();
			// task.setUsername(getLoggedInUserName());
			// taskService.saveTask(task);
			String name = getLoggedInUserName();
			model.addObject("userName", name);
			model.setViewName("addTask");
			return model;
	  }
	
	 @GetMapping(value = "/deleteTask") 
	 public ModelAndView deleteTask(@RequestParam int id){
		 ModelAndView model = new ModelAndView();
		 taskService.deleteTask(id); //
		 String name = getLoggedInUserName();
			model.addObject("tasks", taskService.getTasksByUser(name));
			model.addObject("name",name);
			model.setViewName("listTasks");
			return model;
	 }
	 
	/*
	 * @RequestMapping(value = "/deleteTasks", method = RequestMethod.GET) public
	 * String deleteTask(@RequestParam int id) { taskService.deleteTask(id); //
	 * service.deleteTodo(id); return "redirect:/listTasks"; }
	 * 
	 * @RequestMapping(value = "/addTask", method = RequestMethod.GET) public String
	 * showAddTaskPage(ModelMap model) { model.addAttribute("task", new Task());
	 * return "addTask"; }
	 * 
	 * 
	 * @RequestMapping(value = "/updateTasks", method = RequestMethod.POST) public
	 * String updateTasks(ModelMap model, @Validated Task task, BindingResult
	 * result) {
	 * 
	 * if (result.hasErrors()) { return "task"; }
	 * 
	 * task.setUsername(getLoggedInUserName()); taskService.updateTask(task); return
	 * "redirect:/list-todos"; }
	 */
	@PostMapping(value = "/addTaskItem")
	public ModelAndView addTaskItem(@RequestParam("taskName") String taskName,
			@RequestParam("taskDescription") String taskDesc, @RequestParam("taskDate") String taskDate) throws Exception{
	
		SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(taskName + " " + taskDesc + " " + taskDate);
		 Task task=new Task(taskName,taskDesc,(Date)df.parse(taskDate));

		ModelAndView model = new ModelAndView();
		// task.setUsername(getLoggedInUserName());
		// taskService.saveTask(task);
		String name = getLoggedInUserName();
		task.setUserName(name);
		taskService.saveTask(task);
		model.addObject("tasks", taskService.getTasksByUser(name));
		model.addObject("name",name);
		model.setViewName("listTasks");
		return model;
		// return "listTasks";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}
}
