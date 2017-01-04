package ua.com.hotsport.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.hotsport.dao.NewsDao;
import ua.com.hotsport.dao.PlayerDao;
import ua.com.hotsport.dao.TeamDao;
import ua.com.hotsport.entity.News;
import ua.com.hotsport.entity.Player;
import ua.com.hotsport.entity.Team;
import ua.com.hotsport.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;
	@Autowired
	private PlayerDao playerDao;
	@Autowired
	private NewsDao newsDao;
	
	public void add(Team team) {
		teamDao.save(team);
	}

	public List<Team> findAll() {
		return teamDao.findAll();
	}

	public Team findOne(int id) {
		return teamDao.findOne(id);
	}

	public List<Team> findTeamWithPlayers() {
		return teamDao.findTeamWithPlayer();

	}
	/*
	 * @Transactional public void addPlayerToTeam(Team team, String[] playerIds)
	 * { teamDao.saveAndFlush(team);
	 * 
	 * for (int i = 0; i < playerIds.length; i++) { Player player =
	 * playerDao.findOne(Integer.parseInt(playerIds[i])); player.setTeam(team);
	 * playerDao.save(player);
	 * 
	 * }
	 * 
	 * }
	 */

	

	public void saveAndFlush(Team team) {
		teamDao.saveAndFlush(team);

	}

	@Transactional
	public void delete(int id) {
		Team team = teamDao.findTeamWithPlayer(id);

		for (Player player : team.getPlayers()) {
			player.setTeam(null);
			playerDao.save(player);
		}

		teamDao.delete(team);

	}
	
	@Transactional
	public void deletePlayerFromTeam(int idPlayer) {
		Player player = playerDao.findOne(idPlayer);
		player.setTeam(null);
		playerDao.save(player);

	}

	public void deleteNewsFromTeam1(int idNews) {
		News news = newsDao.findOne(idNews);
		news.setTeam1(null);
		newsDao.save(news);
		
	}
	public void deleteNewsFromTeam2(int idNews) {
		News news = newsDao.findOne(idNews);
		news.setTeam2(null);
		newsDao.save(news);
		
	}

	public List<Team> findTeam1WithNews() {
		// TODO Auto-generated method stub
		return teamDao.findTeam1WithNews();
	}
	public List<Team> findTeam2WithNews() {
		// TODO Auto-generated method stub
		return teamDao.findTeam2WithNews();
	}

	
	
	
	

}
