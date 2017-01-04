package ua.com.hotsport.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.hotsport.entity.News;
import ua.com.hotsport.entity.Team;


public interface NewsDao extends JpaRepository<News, Integer>{
	
	@Query("select distinct a from News a left join fetch a.categories")
	List<News> findNewsWithCategory();
	
	/*@Query("select distinct a from News a left join fetch a.categories where a.id =:id")
	News findNewsWithCategory(@Param("id") int id);*/
	
	@Query("select distinct a from News a left join fetch a.categories c left join fetch a.team1  where c.id =:id ")
	List<News> findOneCategoryNews(@Param("id") int id);

	@Query("select distinct n from News n left join fetch n.categories c")
	List<News> findAllNewsWithCAtegories();
	
	@Query("select distinct n from News n left join fetch n.categories left join fetch n.team1 left join fetch n.team2 where n.id =:id")
	News findDetailedNews(@Param("id") int id);
}
