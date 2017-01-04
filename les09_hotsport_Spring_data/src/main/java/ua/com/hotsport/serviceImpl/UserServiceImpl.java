package ua.com.hotsport.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.hotsport.dao.NewsDao;
import ua.com.hotsport.dao.UserDao;
import ua.com.hotsport.entity.Role;
import ua.com.hotsport.entity.User;
import ua.com.hotsport.service.UserService;
import ua.com.hotsport.validator.Validator;

@Service("userDetailsService") // ("userDetailsService") for spring security
								// 28.11.2016
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private NewsDao newsDao;

	/*
	 * for validation second type - custom type without spring validation
	 * 05.12.2016
	 */
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	// for spring security 28.11.2016
	@Autowired
	private BCryptPasswordEncoder encoder;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public void add(User user) throws Exception {

		validator.validate(user);

		// for spring security 28.11.2016
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		// end for spring security 28.11.2016
		userDao.save(user);

	}

	public User fetchUserWithNews(int id) {
		// TODO Auto-generated method stub
		return userDao.fetchUserWithNews(id);
	}

	@Transactional
	public void deleteNewsFromUser(Principal principal, int id) {
		User user = userDao.findOne(Integer.parseInt(principal.getName()));
		user.getNews().remove(newsDao.findOne(id));

	}

	// for spring security 28.11.2016
	public User findByName(String name) {
		return userDao.findByName(name);
	}

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByName(name);
	}

	/* FOR FILE & IMG UPLOAD 02.12.2016 */
	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {
		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"
				+ multipartFile.getOriginalFilename();

		user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
		userDao.save(user);

	}

	/* FOR EMAIL MESSAGES for confirm registration 07.12.2016 */

	public User findByUUID(String uuid) {
		return userDao.findByUUID(uuid);
	}

	public void update(User user) {
		userDao.save(user);

	}

}
