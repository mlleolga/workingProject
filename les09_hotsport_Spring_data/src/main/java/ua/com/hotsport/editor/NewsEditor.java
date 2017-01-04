package ua.com.hotsport.editor;

import java.beans.PropertyEditorSupport;

import ua.com.hotsport.service.NewsService;

public class NewsEditor extends PropertyEditorSupport {
	private final NewsService newsService;
	
	public NewsEditor(NewsService newsService){
		this.newsService=newsService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(newsService.findOne(Integer.parseInt(text)));
	}
}
