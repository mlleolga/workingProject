package ua.com.hotsport.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
@NamedQuery(name="Country.findAll", query="select c from Country c"),
@NamedQuery(name="findByCountryName", query="select c from Country c where c.name like :name")
})
@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "country")
	private List<Team> teamsCountry;
	
	
/*
	@ManyToMany
	@JoinTable(name = "team_country", 
	joinColumns = @JoinColumn(name = "country_id"), 
	inverseJoinColumns = @JoinColumn(name = "team_id"))
	private List<Team> teams;*/
	
	
	
	
	public Country(String name) {
		this.name = name;
	}
	public Country() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Team> getTeamsCountry() {
		return teamsCountry;
	}
	public void setTeamsCountry(List<Team> teamsCountry) {
		this.teamsCountry = teamsCountry;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", teamsCountry=" + teamsCountry + "]";
	}
	
	
	
	
	
	
}
