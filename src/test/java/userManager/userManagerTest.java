package userManager;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.uxpsystems.assignment.entity.UserTbl;
import com.uxpsystems.assignment.service.UserManager;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/assignment-servlet.xml"})
public class userManagerTest {

	@Autowired
	UserManager userDao;
	
	 @Test
	 public void insert() throws Exception {
		 
		 UserTbl user = new UserTbl(201,"aac","123","Activated","USER");
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
		 UserDetails userp = userDao.loadUserByUsername("ab");
		 System.out.println("User Name is: "+userp.getUsername());
		 assertTrue(userp.getUsername().equals("ab"));
	 }
	 
	 @Test
	 public void updateUser() throws Exception {
		 UserTbl user = new UserTbl(100,"ab","22345","Deactivated","USER");
		 userDao.updateUser(user);
	 }

	 @Test
	 public void deleteUser() throws Exception {
		 
		 userDao.deleteUser(2);
	 }
}
