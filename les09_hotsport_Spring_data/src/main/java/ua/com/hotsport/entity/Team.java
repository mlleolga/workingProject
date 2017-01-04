package ua.com.hotsport.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String img;
	
	@OneToMany(mappedBy="team"/*, cascade = {CascadeType.ALL}*/)
	private List<Player> players;
	
	@ManyToOne
	private Country country;
	
	
	@OneToMany(mappedBy = "team1")
	private List<News> news1;
	
	@OneToMany(mappedBy = "team2")
	private List<News> news2;
	
	
	
	
	/*@ManyToMany
	@JoinTable(name = "team_country", 
	joinColumns = @JoinColumn(name = "team_id"), 
	inverseJoinColumns = @JoinColumn(name = "country_id"))
	private List<Country> countries;
	*/
	
	public Team() {
		
	}
	
	public Team(String title) {
		super();
		this.title = title;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", title=" + title + "]";
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<News> getNews1() {
		return news1;
	}

	public void setNews1(List<News> news1) {
		this.news1 = news1;
	}

	public List<News> getNews2() {
		return news2;
	}

	public void setNews2(List<News> news2) {
		this.news2 = news2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
