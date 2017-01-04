package ua.com.hotsport.service;

import java.util.List;

import ua.com.hotsport.entity.Country;
import ua.com.hotsport.entity.Team;

public interface CountryService {
	void add(Country country);
	List<Country> findAll();
	Country findOne(int id);
	void delete(int id);
	
	void deleteTeamFromCountry(int idTeam);
	
	List<Country> findCountryWithTeam();
	
	void saveAndFlush(Country country);
	
}
