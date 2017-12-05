package com.uxpsystems.assignment.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uxpsystems.assignment.entity.UserTbl;

@Component
@Transactional
public class UserDao {
	private static final Log logger = LogFactory.getLog(UserDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void insertUser(UserTbl user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public UserTbl getUserById(long userId) {
		logger.debug("UserDao.getUserById" + userId);
		Session session = sessionFactory.getCurrentSession();
		logger.debug("UserDao.getUserById session" + session);
		UserTbl user = (UserTbl) session.get(UserTbl.class, userId);
		return user;
	}

	public UserTbl getUserByName(String username) {
		String hql = "FROM UserTbl WHERE username = '" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserTbl> results = query.list();
		UserTbl user = null;
		if (results != null && !results.isEmpty()) {
			user = (UserTbl) results.get(0);
		}
		return user;
	}

	public void updateUser(UserTbl user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}

	public void deleteUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserTbl user = (UserTbl) session.load(UserTbl.class, new Long(id));
		if (null != user) {
			session.delete(user);
		}
	}
}
