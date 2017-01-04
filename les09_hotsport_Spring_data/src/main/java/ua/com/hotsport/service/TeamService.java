package ua.com.hotsport.service;

import java.util.List;

import ua.com.hotsport.entity.Team;


public interface TeamService {
	void add(Team team);
	List<Team> findAll();
	void delete(int id);
	Team findOne(int id);
	
	/*void addPlayerToTeam(Team team, String [] playerIds);*/
	
	void deletePlayerFromTeam(int idPlayer);
	
	List<Team> findTeamWithPlayers();
	
		/*FOR ADDING TEAM1 & TEAM2 INTO  NEWS*/
		void deleteNewsFromTeam1(int idNews);
		void deleteNewsFromTeam2(int idNews);
	
		List<Team> findTeam1WithNews();
		List<Team> findTeam2WithNews();
	
	
	
	void saveAndFlush(Team team);
	
}
