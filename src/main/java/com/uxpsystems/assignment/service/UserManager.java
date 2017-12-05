package com.uxpsystems.assignment.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.UserPrincipal;
import com.uxpsystems.assignment.entity.UserTbl;

@Service
public class UserManager implements UserDetailsService {
	private static final Log logger = LogFactory.getLog(UserManager.class);

	@Autowired
	private UserDao userDao;

	public void insertUser(UserTbl user) {
		user.setRole("USER");
		BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
		user.setPassword(pw.encode(user.getPassword()));

		userDao.insertUser(user);
	}

	public void updateUser(UserTbl user) {
		user.setRole("USER");
		BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
		user.setPassword(pw.encode(user.getPassword()));
		userDao.updateUser(user);
	}

	public void deleteUser(long userId) {
		userDao.deleteUser(userId);
	}

	public UserTbl getUserById(long userId) {
		logger.debug("UserManager.getUserById" + userId);
		return userDao.getUserById(userId);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserTbl user = userDao.getUserByName(userName);
		if (user == null) {
			UsernameNotFoundException e = new UsernameNotFoundException("User: " + userName + " not found!");
			throw e;
		}
		UserPrincipal userP = new UserPrincipal(user);
		return userP;
	}
}
