package ua.com.hotsport.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.hotsport.entity.User;
import ua.com.hotsport.service.MailSenderService;
import ua.com.hotsport.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*FOR EMAIL MESSAGES for confirm registration 07.12.2016*/	
	@Autowired
	private MailSenderService mailSenderService;
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());
		
		
		
		
		return "views-admin-newUser";
	}
	
	/*@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model) {

		userService.add(user);

		return "redirect:/newUser";
	}*/
	
	/*for validation second type - custom type without spring validation 05.12.2016*/
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model) {
		
String uuid = UUID.randomUUID().toString();   /*FOR EMAIL MESSAGES for confirm registration 07.12.2016*/	
		
		user.setUUID(uuid);    /*FOR EMAIL MESSAGES for confirm registration 07.12.2016*/	
		

		try{
			userService.add(user);
		}catch(Exception e){
			model.addAttribute("exception", e.getMessage());
			return "registration";
		}
		
		String theme = "thank's for registration";     /*FOR EMAIL MESSAGES for confirm registration 07.12.2016*/	
		String message = "gl & hf http://localhost:8080/les09_hotsport_Spring_data/confirm/" + uuid;  /*FOR EMAIL MESSAGES for confirm registration 07.12.2016*/	
		
mailSenderService.sendMail(theme, message, user.getEmail());

		return "redirect:/"; // 
	}
	
	/*FOR EMAIL MESSAGES for confirm registration 07.12.2016*/	
	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid){
		
		User user = userService.findByUUID(uuid);
		user.setEnabled(true);
		
		userService.update(user);
		
		return "redirect:/";
	}

	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String newUser(@PathVariable int id) {

		userService.delete(id);

		return "redirect:/newUser";
	}

	@RequestMapping(value = "/deleteNewsFromUser/{id}", method = RequestMethod.GET)
	public String deleteNewsFromUser(Principal principal, @PathVariable String id) {
		
		userService.deleteNewsFromUser(principal, Integer.parseInt(id));

		return "redirect:/newUser";
	}
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model){
		System.out.println(principal.getName() + "   " );
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		
		model.addAttribute("user", user);
		
		return "views-user-profile";
		
		
	}
	
	
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public String allUsers(Model model) {
model.addAttribute("users", userService.findAll());

		return "views-admin-allUsers";
	}
	
	/*FOR FILE & IMG UPLOAD 02.12.2016*/
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image){
		userService.saveImage(principal, image);
		return "redirect:/profile";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
