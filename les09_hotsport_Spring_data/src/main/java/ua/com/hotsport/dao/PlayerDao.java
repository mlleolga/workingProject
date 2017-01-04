package ua.com.hotsport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.hotsport.entity.Player;

public interface PlayerDao extends JpaRepository<Player, Integer>{
	
	
	
}
