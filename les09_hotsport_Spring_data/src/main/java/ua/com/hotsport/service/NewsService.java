package ua.com.hotsport.service;

import java.util.List;


import ua.com.hotsport.entity.News;

public interface NewsService {
	void add(News news);
	List<News> findAll();
	News findOne(int id);
	void delete(int id);
	
	
	List<News> findNewsWithCategory();
	
	void saveAndFlush(News news);
	
	List<News> findOneCategoryNews(int id);
	
	List<News> findNewsWithDate();
	 News findDetailedNews(int id);
	
		List<News> findAllReturned();
		
		List<News> sortNewsByDate();
		
		
}
