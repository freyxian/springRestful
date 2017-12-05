package userManager;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.UserTbl;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/assignment-servlet.xml"})
public class UserDaoTest {
	@Autowired
	UserDao userDao;
	
	 @Test
	 public void insert() throws Exception {
		 
		 UserTbl user = new UserTbl(101,"aab","123","Activated","USER");
		 //UserDao userDao = (UserDao) context.getBean("com.uxpsystems.assignment.dao.UserDao");
		 userDao.insertUser(user);
	 }
	
	 @Test
	 public void findById() throws Exception {
		 UserTbl user = userDao.getUserById(100);
		 System.out.println("User Name is: "+user.getUsername());
		 assertTrue(user.getId()==100);
	 }
	
	 @Test
	 public void findByName() throws Exception {
		 UserTbl user = userDao.getUserByName("aaa");
		 System.out.println("User Name is: "+user.getUsername());
		 assertTrue(user.getId()==100);
	 }
	 
	 @Test
	 public void updateUser() throws Exception {
		 UserTbl user = new UserTbl(100,"ab","12345","Deactivated","USER");
		 userDao.updateUser(user);
	 }
	 
	 @Test
	 public void deleteUser() throws Exception {
		 
		 userDao.deleteUser(1);
	 }
}
