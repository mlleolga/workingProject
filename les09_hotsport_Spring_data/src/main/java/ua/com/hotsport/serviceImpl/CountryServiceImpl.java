package ua.com.hotsport.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.hotsport.dao.CountryDao;
import ua.com.hotsport.dao.TeamDao;
import ua.com.hotsport.entity.Country;
import ua.com.hotsport.entity.Player;
import ua.com.hotsport.entity.Team;
import ua.com.hotsport.service.CountryService;

@Service("countryService")
public class CountryServiceImpl implements CountryService{
	
	
	@Autowired
	private  CountryDao countryDao;
	@Autowired
	private TeamDao teamDao;
	
	public void add(Country country) {
		// TODO Auto-generated method stub
		countryDao.save(country);
	}

	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return countryDao.findAll();
	}

	public Country findOne(int id) {
		// TODO Auto-generated method stub
		return countryDao.findOne(id);
	}

	public void delete(int id) {
		Country country = countryDao.findCountryWithTeam(id);
		
		for (Team team : country.getTeamsCountry()) {
			team.setCountry(null);
			teamDao.save(team);
		}

		countryDao.delete(country);
		
	}

	public void deleteTeamFromCountry(int idTeam) {
		Team team = teamDao.findOne(idTeam);
		team.setCountry(null);
		teamDao.save(team);
	}

	public List<Country> findCountryWithTeam() {
		
		return countryDao.findCountryWithTeam();
	}

	public void saveAndFlush(Country country) {
		countryDao.saveAndFlush(country);
		
	}

	
	
}
