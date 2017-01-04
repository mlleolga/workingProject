package ua.com.hotsport.service;
/*FOR EMAIL MESSAGES for confirm registration 07.12.2016*/	
public interface MailSenderService {
	void sendMail(String content, String mailBody, String email);

}
