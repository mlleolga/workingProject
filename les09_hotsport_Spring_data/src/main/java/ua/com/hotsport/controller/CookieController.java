package ua.com.hotsport.controller;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.hotsport.service.NewsService;
import ua.com.hotsport.service.UserService;
@Controller
public class CookieController {
	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	
	
	
}
