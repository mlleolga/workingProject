package ua.com.hotsport.dto;

import java.time.LocalDate;

public class NewsDTO {
	private int id;
	private String title;
	private String shortStory;
	private String fullStory;
	private LocalDate dateofPublic;
	
	
	
	
	public NewsDTO() {
		super();
	}




	public NewsDTO(int id, String title, String shortStory, String fullStory, LocalDate dateofPublic) {
		super();
		this.id = id;
		this.title = title;
		this.shortStory = shortStory;
		this.fullStory = fullStory;
		this.dateofPublic = dateofPublic;
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




	public String getShortStory() {
		return shortStory;
	}




	public void setShortStory(String shortStory) {
		this.shortStory = shortStory;
	}




	public String getFullStory() {
		return fullStory;
	}




	public void setFullStory(String fullStory) {
		this.fullStory = fullStory;
	}




	public LocalDate getDateofPublic() {
		return dateofPublic;
	}




	public void setDateofPublic(LocalDate dateofPublic) {
		this.dateofPublic = dateofPublic;
	}




	@Override
	public String toString() {
		return "NewsDTO [id=" + id + ", title=" + title + ", shortStory=" + shortStory + ", fullStory=" + fullStory
				+ ", dateofPublic=" + dateofPublic + "]";
	}

	
	
}
