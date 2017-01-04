package ua.com.hotsport.validator.userValidatorImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ua.com.hotsport.dao.UserDao;
import ua.com.hotsport.entity.User;
import ua.com.hotsport.validator.Validator;
@Component("userValidator")
public class UserValidator implements Validator{
	@Autowired
	private UserDao userDao;

	public void validate(Object object) throws Exception {
		User user = (User) object;
		
		if(user.getName().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_USERNAME_FIELD);
		}
		
		if(userDao.findByName(user.getName()) !=null){
			throw new UserValidationException(UserValidationMessages.NAME_ALREADY_EXIST);
		}
		
		
		
		
		if(userDao.userExistByEmail(user.getEmail())){
			throw new UserValidationException(UserValidationMessages.EMPTY_EMAIL_FIELD);
		}	
		if(userDao.findByName(user.getEmail()) !=null){
			throw new UserValidationException(UserValidationMessages.EMAIL_ALREADY_EXIST);
			
			
		}
		if(user.getPassword().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_PASSWORD_FIELD);
		}
		
	}

	



	

	
	
}
