package ua.com.hotsport.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.hotsport.entity.Country;


public interface CountryDao extends JpaRepository<Country, Integer>{
	
	@Query("select distinct a from Country a left join fetch a.teamsCountry")
	List<Country> findCountryWithTeam();
	
	@Query("select distinct a from Country a left join fetch a.teamsCountry where a.id =:id")
	Country findCountryWithTeam(@Param("id") int id);

}
