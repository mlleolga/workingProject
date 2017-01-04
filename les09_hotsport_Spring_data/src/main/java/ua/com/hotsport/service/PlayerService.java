package ua.com.hotsport.service;

import java.util.List;

import ua.com.hotsport.entity.Player;

public interface PlayerService {
	void add(Player player);
	List<Player> findAll();
	Player findOne(int id);
	void delete(int id);
	
	
}
