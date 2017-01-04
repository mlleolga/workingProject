package ua.com.hotsport.service;

import java.util.List;

import ua.com.hotsport.entity.Category;
import ua.com.hotsport.entity.Team;

public interface CategoryService {
	
	void add(Category category);
	List<Category> findAll();
	Category findOne(int id);
	void delete(int id);
	
	
	
}
