package ua.com.hotsport.editor;

import java.beans.PropertyEditorSupport;

import ua.com.hotsport.service.CategoryService;


public class CategoryEditor extends PropertyEditorSupport{
	private final CategoryService categoryService;
	
	public CategoryEditor(CategoryService categoryService){
		this.categoryService=categoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(categoryService.findOne(Integer.parseInt(text)));
	}
		
}
