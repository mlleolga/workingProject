package ua.com.hotsport.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.com.hotsport.dto.DtoUtilMapper;
import ua.com.hotsport.dto.NewsDTO;
import ua.com.hotsport.entity.News;
import ua.com.hotsport.service.NewsService;

@RestController
public class JSController {

	@Autowired
	private NewsService newsService;
	
	
	
	
	@RequestMapping(value = "listFilter", method = RequestMethod.POST)
	public List<NewsDTO> listFilter(@RequestBody String id){
	System.out.println("----------------------------------------------------");
		
		return DtoUtilMapper.newsToNewsDTO(newsService.findAllReturned());
	
	}
	
	@RequestMapping(value = "listDateFilter", method = RequestMethod.POST)
	public List<NewsDTO> listDateFilter(@RequestBody  String id/*News news*/){
	System.out.println("----------------------------------------------------");
	/*System.out.println(news);*/
	/*news.setDateofPublic(new LocalDate);*/
	/*newsService.add(news);*/
		return DtoUtilMapper.newsToNewsDTO(newsService.findNewsWithDate());
	
	}
	
	
	
	
	
}
