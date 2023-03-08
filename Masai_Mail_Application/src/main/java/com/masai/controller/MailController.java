package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.EmailDTO;
import com.masai.service.EmailService;

@RestController
@RequestMapping("/masaimail")
public class MailController {

	@Autowired
	private EmailService mailService;

	@PostMapping("/mail")
	public ResponseEntity<Email> sendEmailHandeler(@Valid @RequestBody EmailDTO emailDTO,
			@RequestParam("userEmail") String userEmail, @RequestParam("toEmail") String toEmail)
			throws EmailException, UserException, LoginException {
		return new ResponseEntity<Email>(mailService.sendMail(emailDTO, userEmail, toEmail), HttpStatus.OK);
	}
	
	

	@PutMapping("/starred/{emailId}")
	public ResponseEntity<Email> starredEmailHandler(@Valid @PathVariable("emailId") Integer emailId)
			throws EmailException, LoginException {
		return new ResponseEntity<Email>(mailService.starredMmail(emailId), HttpStatus.OK);
	}

	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Email> deleteEmailHandeler(@PathVariable("id") Integer mailId)
			throws EmailException, LoginException, UserException {
		return new ResponseEntity<Email>(mailService.deleteMail(mailId), HttpStatus.OK);
	}

}
