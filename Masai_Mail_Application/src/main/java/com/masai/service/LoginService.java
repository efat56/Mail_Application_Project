package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.Login;

public interface LoginService {

	public String logInAccount(Login login) throws LoginException;

	public String logoutAccount(String email, String Ukey) throws LoginException;

}
