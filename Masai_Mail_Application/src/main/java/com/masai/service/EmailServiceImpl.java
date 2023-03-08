package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.EmailDTO;
import com.masai.model.Login;
import com.masai.model.User;
import com.masai.repository.LoginRepo;
import com.masai.repository.EmailRepo;
import com.masai.repository.UserRepo;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepo Erepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private LoginRepo lRepo;

	
	public void checkLoginStatus(String email) throws LoginException {

		Login loginData = lRepo.findByEmail(email);
		if (loginData == null)
			throw new LoginException("User login required!");
	}

	
	public User getuser(String userEmail) throws UserException {

		User existsingUser = userRepo.findByEmail(userEmail);
		if (existsingUser == null)
			throw new UserException("User not found with email : " + userEmail);
		return existsingUser;
	}

	
	public Email getEmail(Integer emailId) throws EmailException {

		Optional<Email> emailOpt = Erepo.findById(emailId);
		if (emailOpt.isEmpty())
			throw new EmailException("Email not found with id: " + emailId);

		return emailOpt.get();
	}

	@Override
	public Email sendMail(EmailDTO emailDTO, String fromEmail, String toEmail)
			throws EmailException, UserException, LoginException {

		
		checkLoginStatus(fromEmail);

		
		User user = getuser(fromEmail);

		if (emailDTO == null)
			throw new EmailException("Email data can't be null");

		Email newMail = new Email();
		newMail.setFromEmail(fromEmail);
		newMail.setToEmail(toEmail);
		newMail.setSubject(emailDTO.getSubject());
		newMail.setDescription(emailDTO.getDescription());
		newMail.setStar(emailDTO.getStar());

		user.getEmailList().add(newMail);
		return Erepo.save(newMail);
	}

	@Override
	public Email starredMmail(Integer emailId) throws EmailException, LoginException {

		
		Email email = getEmail(emailId);

		if (email.getStar()) {

			email.setStar(false);
			return Erepo.save(email);

		} else {
			email.setStar(true);
			return Erepo.save(email);
		}

	}

	@Override
	public Email deleteMail(Integer emailId) throws EmailException, LoginException, UserException {

		
		Email exixtingEmail = getEmail(emailId);

		String UsereEmail = exixtingEmail.getFromEmail();
		User user = getuser(UsereEmail);

		Email deletedEmail = null;

		List<Email> emailList = user.getEmailList();
		for (int i = 0; i < emailList.size(); i++) {
			Email email = emailList.get(i);
			if (email.getId() == emailId) {
				deletedEmail = email;
				emailList.remove(i);

			}
		}
		user.setEmailList(emailList);
		userRepo.save(user);
		return deletedEmail;
	}

}
