package ua.com.hotsport.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.hotsport.entity.User;

public interface UserService {
	void add(User user) throws Exception;

	List<User> findAll();

	void delete(int id);

	User findOne(int id);

	User fetchUserWithNews(int id);

	void deleteNewsFromUser(Principal principal, int id);

	public void saveImage(Principal principal, MultipartFile multipartFile);

	/* FOR EMAIL MESSAGES for confirm registration 07.12.2016 */
	User findByUUID(String uuid);
	void update(User user);
}
