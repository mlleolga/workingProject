package ua.com.hotsport.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
/*	private String category;*/
	private String shortStory;
	private String fullStory;
	private LocalDate dateofPublic;

	

	@ManyToMany
	@JoinTable(name = "user_news", joinColumns = @JoinColumn(name = "news_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	@ManyToMany
	@JoinTable(name = "news_category", joinColumns = @JoinColumn(name = "news_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;

	@ManyToOne
	private Team team1;

	@ManyToOne
	private Team team2;

	public News() {

	}
	
	

	public News(String title) {
		super();
		this.title = title;
	}



	public News(String title, String category, List<Category> categories) {
		super();
		this.title = title;
		/*this.category = category;*/
		this.categories = categories;
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

	/*public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
*/
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public LocalDate getDateofPublic() {
		return dateofPublic;
	}



	public void setDateofPublic(LocalDate dateofPublic) {
		this.dateofPublic = dateofPublic;
	}



	public Team getTeam1() {
		return team1;
	}



	public void setTeam1(Team team1) {
		this.team1 = team1;
	}



	public Team getTeam2() {
		return team2;
	}



	public void setTeam2(Team team2) {
		this.team2 = team2;
	}



	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", shortStory=" + shortStory + ", fullStory=" + fullStory
				+ ", dateofPublic=" + dateofPublic + "]";
	}
	
	
}
