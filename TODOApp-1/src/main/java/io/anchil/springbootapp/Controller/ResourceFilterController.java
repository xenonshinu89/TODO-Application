package io.anchil.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.anchil.springbootapp.Service.TaskService;

@Controller
public class ResourceFilterController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/")
	public ModelAndView home()
	{
		ModelAndView homeMV=new ModelAndView();
		homeMV.addObject("Title","Welcome  to Todo App Page");
		homeMV.addObject("userName",getLoggedinUserName());
		homeMV.setViewName("Welcome");
		return homeMV;
	}
	
	@GetMapping("/user")
	public ModelAndView userLogin()
	{
		ModelAndView homeUser=new ModelAndView();
		homeUser.addObject("Title","Welcome User");
		homeUser.addObject("userName",getLoggedinUserName());
		homeUser.setViewName("UserPage");
		return homeUser;
	}
	
	@GetMapping("/admin")
	public ModelAndView adminLogin()
	{
		ModelAndView homeAdmin=new ModelAndView();
		homeAdmin.addObject("Title","Welcome Admin");
		homeAdmin.addObject("user",getLoggedinUserName());
		homeAdmin.addObject("tasks", taskService.getAllTasks());
		homeAdmin.setViewName("AdminPage");
		return homeAdmin;
	}
	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

}
