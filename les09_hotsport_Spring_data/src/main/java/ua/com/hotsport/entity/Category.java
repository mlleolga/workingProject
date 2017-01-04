package ua.com.hotsport.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String description;
	
	@ManyToMany
	@JoinTable(name="news_category",
	joinColumns=@JoinColumn(name = "category_id"),
	inverseJoinColumns = @JoinColumn(name = "news_id"))
	private List<News> news;
	
	
	
	public Category() {
		
	}
	
	
	
	

	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}





	public List<News> getNews() {
		return news;
	}





	public void setNews(List<News> news) {
		this.news = news;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}





	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", description=" + description + ", news=" + news + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
