package ua.com.hotsport.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.hotsport.entity.Category;


public interface CategoryDao extends JpaRepository<Category, Integer>{
	
}
