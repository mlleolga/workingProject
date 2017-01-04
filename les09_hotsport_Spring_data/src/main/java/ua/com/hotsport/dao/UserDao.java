package ua.com.hotsport.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.hotsport.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	// for spring security 28.11.2016
	User findByName(String name);
	//end  for spring security
	@Query("select distinct u from User u left join fetch u.news where u.id =:id")
	User fetchUserWithNews(@Param("id") int id);

	/*	For Validation 05.12.2016*/
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.name=:name")
	boolean userExistByEmail(@Param("name") String name);
	
	/*FOR EMAIL MESSAGES for confirm registration 07.12.2016*/	
	@Query("select u from User u where u.UUID =:uuid")
	User findByUUID(@Param("uuid") String uuid); 

}
