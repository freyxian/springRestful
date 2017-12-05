package com.uxpsystems.assignment.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.security.SecureRandom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxpsystems.assignment.entity.UserTbl;
import com.uxpsystems.assignment.service.UserManager;

@Controller
public class UserController {

	private static final Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	UserManager home;
	
	@RequestMapping(value="/user", method=GET)
	@ResponseBody
	
	public UserTbl userGet(@RequestParam("data")  int id ) {
		logger.debug("User get json:"+id);
		UserTbl user1 = home.getUserById(id);
	return user1;
	}
	
	@RequestMapping(value="/user", method=POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
	public  UserTbl userPost(@RequestBody UserTbl s_user ) {
		logger.debug("User get json:"+s_user.toString());
		home.insertUser(s_user);
	return s_user;
	}
	
	@RequestMapping(value="/user", method=PUT,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
	public  UserTbl userPut(@RequestBody UserTbl s_user ) {
		logger.debug("User get json:"+s_user.toString());
		home.updateUser(s_user);
	return s_user;
	}
	
	@RequestMapping(value="/user", method=DELETE,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
	public  UserTbl userDelete(@RequestBody UserTbl s_user ) {
		logger.debug("User get json:"+s_user.toString());
		home.deleteUser(s_user.getId());
	return s_user;
	}
}
