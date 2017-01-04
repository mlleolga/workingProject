package ua.com.hotsport.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.hotsport.dao.CategoryDao;
import ua.com.hotsport.entity.Category;
import ua.com.hotsport.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;

	public void add(Category category) {
		categoryDao.save(category);
		
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);
		
	}
	
}
