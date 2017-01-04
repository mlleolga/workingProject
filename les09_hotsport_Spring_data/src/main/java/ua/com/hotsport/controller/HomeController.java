package ua.com.hotsport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.hotsport.service.CategoryService;
import ua.com.hotsport.service.NewsService;


@Controller
public class HomeController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private NewsService newsService;
	@RequestMapping(value= { "/", "/home" }, method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("news", newsService.findNewsWithDate());
		return "views-base-home";
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocesing() {
		return "redirect:/home";
	}

	@RequestMapping("/loginpage")
	public String login() {
		return "views-user-loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}
	
	@RequestMapping(value= "/admin", method=RequestMethod.GET)
	public String blablavla(){
		
		return "views-admin-admin";
	}
	
	
}

