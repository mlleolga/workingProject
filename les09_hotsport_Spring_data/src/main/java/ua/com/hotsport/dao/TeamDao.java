package ua.com.hotsport.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.hotsport.entity.Team;




public interface TeamDao extends JpaRepository<Team, Integer>{
	
	@Query("select distinct a from Team a left join fetch a.players")
	List<Team> findTeamWithPlayer();
	
	@Query("select distinct a from Team a left join fetch a.players where a.id =:id")
	Team findTeamWithPlayer(@Param("id") int id);
	
	/*FOR ADDING TEAM1 & TEAM2 INTO  NEWS*/
	
	@Query("select distinct a from Team a left join fetch a.news1")
	List<Team> findTeam1WithNews();
	
	@Query("select distinct a from Team a left join fetch a.news1 where a.id =:id")
	Team findTeam1WithNews(@Param("id") int id);
	

	@Query("select distinct a from Team a left join fetch a.news2")
	List<Team> findTeam2WithNews();
	
	@Query("select distinct a from Team a left join fetch a.news2 where a.id =:id")
	Team findTeam2WithNews(@Param("id") int id);
}
