package emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import emp.dao.EmployeeDao;
import emp.dto.Employee;

@Controller

public class EmployeeController 
{
	
	@Autowired
	Employee employee;
	
	@Autowired
	EmployeeDao dao;
	
	@GetMapping("load")
	public ModelAndView loadEmployee() {
		ModelAndView andView=new ModelAndView("Signup.jsp");
		  
		andView.addObject("emp",employee);
		return andView;
		
	}
	@PostMapping("Signup")
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) 
	{
		dao.signupEmployee(emp);
		ModelAndView andView=new ModelAndView("Login.jsp");
		andView.addObject("msg", "Account created successfully");
		return andView;
		
	}
	@PostMapping("Login")
	public ModelAndView login(@RequestParam String email, @RequestParam String pwd)
	{
		//ModelAndView andView=new ModelAndView("Result.jsp");
		//andView.addObject("email",email);
		//andView.addObject("password",pwd);
		//return andView;
		ModelAndView andView=new ModelAndView();
		Employee employee=dao.login(email);
		if(employee==null)
		{
			andView.setViewName("Login.jsp");
			andView.addObject("msg","invalid email");
			
		}else {
			if(pwd.equals(employee.getPassword())){
				andView.setViewName("Result.jsp");
				andView.addObject("list", dao.fetchAll());
				andView.addObject("msg", "Logged in successful");
			}else {
				andView.setViewName("Login.jsp");
				andView.addObject("msg", "Inavalid password");
			}
		}
		return andView;
		
	}
	
		
	

}
