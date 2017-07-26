package com.patriotenergygroup.peadminservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patriotenergygroup.peadminservice.security.domain.User;

@RestController
@RequestMapping("/account")
public class AccountController {
	private final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping(path="/roles", method = RequestMethod.GET)
	public ResponseEntity<?> getRoles() {
        logger.debug("Fetching users");
		
        return new ResponseEntity<>("Successfully created", new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(path="/users", method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
        logger.debug("Fetching users");
		
        return new ResponseEntity<>("Successfully created", new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(path="/user", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(long id) {
        logger.debug("Getting user");
		
        return new ResponseEntity<>("Successfully created", new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<?> create(@RequestBody User user) {
        logger.debug("Creating user");
		
        return new ResponseEntity<>("Successfully created", new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(path="/user", method=RequestMethod.PATCH)
	public ResponseEntity<?> update(@RequestBody User user) {
        logger.debug("Updating user");
		
        return new ResponseEntity<>("Successfully updated", new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(path="/user", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(long id) {
        logger.debug("Deleting user");
		
        return new ResponseEntity<>("Successfully updated", new HttpHeaders(), HttpStatus.OK);
	}
	
}
