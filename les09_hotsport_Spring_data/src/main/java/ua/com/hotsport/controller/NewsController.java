package ua.com.hotsport.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.hotsport.editor.CategoryEditor;
import ua.com.hotsport.editor.CountryEditor;
import ua.com.hotsport.editor.PlayerEditor;
import ua.com.hotsport.editor.TeamEditor;
import ua.com.hotsport.entity.Category;
import ua.com.hotsport.entity.Country;
import ua.com.hotsport.entity.News;
import ua.com.hotsport.entity.Player;
import ua.com.hotsport.entity.Team;
import ua.com.hotsport.service.CategoryService;
import ua.com.hotsport.service.NewsService;
import ua.com.hotsport.service.TeamService;

import ua.com.hotsport.dto.DtoUtilMapper;


@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private CategoryService categoryService;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(Team.class, new TeamEditor(teamService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
}
	
	@RequestMapping(value = "/newNews", method = RequestMethod.GET)
	public String newNews(Model model) {
		
		
		model.addAttribute("news", newsService.findAll());
		model.addAttribute("newsIn", new News());
		
		model.addAttribute("teams1DTOs", DtoUtilMapper.teamsToTeamsDTO(teamService.findAll()));
		model.addAttribute("teams2DTOs", DtoUtilMapper.teamsToTeamsDTO(teamService.findAll()));
		
		
	//	model.addAttribute("categoryDTOs", DtoUtilMapper.categoriesToCategoriesDTO(categoryService.findAll()));
		model.addAttribute("categor", categoryService.findAll());
		
		
		return "views-admin-newNews";
	}
	
	
	
	
	@RequestMapping(value = "/saveNews", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute News newsIn, @RequestParam String date) {
		
		newsIn.setDateofPublic(LocalDate.parse(date));

		newsService.add(newsIn);

		return "redirect:/newNews";
	}

	@RequestMapping(value = "/deleteNews/{id}", method = RequestMethod.GET)
	public String News(@PathVariable int id) {

		newsService.delete(id);

		return "redirect:/newNews";
	}
	
	@RequestMapping(value = "/detailed/{id}", method = RequestMethod.GET)
	public String DetailedNews(Model model, @PathVariable String id) {
	model.addAttribute("news", newsService.findDetailedNews(Integer.parseInt(id)));
	
	return "views-base-detailed";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
