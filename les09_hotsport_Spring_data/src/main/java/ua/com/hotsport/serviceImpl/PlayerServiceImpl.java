package ua.com.hotsport.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.hotsport.dao.PlayerDao;
import ua.com.hotsport.entity.Country;
import ua.com.hotsport.entity.Player;
import ua.com.hotsport.service.PlayerService;


@Service("playerService")
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	private PlayerDao playerDao;

	public void add(Player player) {
		// TODO Auto-generated method stub
		playerDao.save(player);
	}

	public List<Player> findAll() {
		// TODO Auto-generated method stub
		return playerDao.findAll();
	}

	public Player findOne(int id) {
		// TODO Auto-generated method stub
		return playerDao.findOne(id);
	}

	public void delete(int id) {
		playerDao.delete(id);
		
	}
	

	

}
