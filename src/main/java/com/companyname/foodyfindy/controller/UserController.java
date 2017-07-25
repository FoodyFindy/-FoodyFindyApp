package com.companyname.foodyfindy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author lingadal
 *
 */

import com.companyname.foodyfindy.domain.User;
import com.companyname.foodyfindy.exception.FoodyFindyException;
import com.companyname.foodyfindy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) throws FoodyFindyException {
		userService.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user) throws FoodyFindyException {
		userService.update(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable String userId) throws FoodyFindyException {
		User user = userService.get(userId);
		return user;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String userId) throws FoodyFindyException {
		userService.delete(userId);
	}

}
