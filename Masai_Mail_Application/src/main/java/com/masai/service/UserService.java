package com.masai.service;

import java.util.List;

import com.masai.exception.EmailException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.model.UserUpdateDTO;

public interface UserService {

	public User registerUser(UserDTO userDTO) throws UserException;

	public List<Email> checkMail(String userEmail) throws UserException, EmailException, LoginException;

	public List<Email> checkStarredMail(String userEmail) throws UserException, EmailException, LoginException;

	public User updateUser(UserUpdateDTO userUpdateDTO, String userEmail) throws UserException, LoginException;
}
