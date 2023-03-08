package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmailException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.model.UserUpdateDTO;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaimail")
public class UserController 
{

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO) throws UserException {
		return new ResponseEntity<User>(userService.registerUser(userDTO), HttpStatus.CREATED);
	}

	@GetMapping("/mail")
	public ResponseEntity<List<Email>> checkAllMail(@Valid @RequestParam("userEmail") String userEmail)
			throws UserException, EmailException, LoginException {
		return new ResponseEntity<List<Email>>(userService.checkMail(userEmail), HttpStatus.OK);
	}

	@GetMapping("/starred")
	public ResponseEntity<List<Email>> checkAllStarredMail(@Valid @RequestParam("userEmail") String userEmail)
			throws UserException, EmailException, LoginException {
		return new ResponseEntity<List<Email>>(userService.checkStarredMail(userEmail), HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@Valid @RequestBody UserUpdateDTO userDTO,
			@RequestParam("userEmail") String userEmail) throws UserException, LoginException 
	{
		return new ResponseEntity<User>(userService.updateUser(userDTO, userEmail), HttpStatus.OK);
	}

}
