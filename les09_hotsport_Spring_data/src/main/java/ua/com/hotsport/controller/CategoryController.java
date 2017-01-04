package ua.com.hotsport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.hotsport.editor.NewsEditor;
import ua.com.hotsport.entity.Category;
import ua.com.hotsport.entity.News;
import ua.com.hotsport.service.CategoryService;
import ua.com.hotsport.service.NewsService;
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private NewsService newsService;
	
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(News.class, new NewsEditor(newsService));
	}

	@RequestMapping(value = "/newCategory", method = RequestMethod.GET)
	public String newCategory(Model model) {

		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("categoryIn", new Category());
				
		model.addAttribute("news", newsService.findAll());

		return "views-admin-newCategory";
	}

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category categoryIn) {
		System.out.println("the save category");
		categoryService.add(categoryIn);

		return "redirect:/newCategory";
	}

	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
	public String newCategory(@PathVariable String id) {

		categoryService.delete(Integer.parseInt(id));

		return "redirect:/newCategory";
	}

	
	
	
	@RequestMapping(value = "/showNews/{id}", method = RequestMethod.GET)
	public String categoryNews(Model model, @PathVariable String id) {
		
		
	model.addAttribute("news", newsService.findOneCategoryNews(Integer.parseInt(id)));
		
		
		return "views-base-showNews";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
