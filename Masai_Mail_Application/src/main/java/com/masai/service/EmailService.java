package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.EmailDTO;

public interface EmailService {

	public Email sendMail(EmailDTO email, String fromEmail, String toEmail)
			throws EmailException, UserException, LoginException;

	public Email starredMmail(Integer emailId) throws EmailException, LoginException;

	public Email deleteMail(Integer emailId) throws EmailException, LoginException, UserException;

}
