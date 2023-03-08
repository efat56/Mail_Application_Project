package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Login;
import com.masai.model.User;
import com.masai.repository.LoginRepo;
import com.masai.repository.UserRepo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private LoginRepo lRepo;

	@Override
	public String logInAccount(Login login) throws LoginException 
	{

		User user = userRepo.findByEmail(login.getEmail());
		if (user == null)
			throw new LoginException("Email id not found!");

		if (user.getPassword().equals(login.getPassword())) 
		{

			Login loginData = lRepo.findByEmail(login.getEmail());
			if (loginData != null)
				throw new LoginException("User already logged-In!");

			Login newLoginData = new Login();
			newLoginData.setEmail(login.getEmail());
			newLoginData.setPassword(login.getPassword());
			newLoginData.setDate(LocalDateTime.now());

			String key = RandomString.make(6);
			newLoginData.setLoginKey(key);
			lRepo.save(newLoginData);

			return "Login Sucessufull! ( key - " + key + " )";

		}
		else
		{
			throw new LoginException("Invalid password");
		}
	}

	@Override
	public String logoutAccount(String email, String Ukey) throws LoginException {

		User user = userRepo.findByEmail(email);
		if (user == null)
			throw new LoginException("Invalid email...!");

		Login loginData = lRepo.findByEmail(email);
		if (loginData == null)
			throw new LoginException("User didn't log..!");

		if (loginData.getLoginKey().equals(Ukey)) {

			Login deletedLoginData = loginData;
			lRepo.delete(deletedLoginData);

			return "Logout succesfull...!";

		} else {
			throw new LoginException("Invalid login Creditionals..!");
		}
	}
}
