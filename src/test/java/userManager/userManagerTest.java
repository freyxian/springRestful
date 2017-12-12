package userManager;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.uxpsystems.assignment.entity.UserTbl;
import com.uxpsystems.assignment.service.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/assignment-servlet.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class userManagerTest {

	@Autowired
	UserManager userDao;
	
	 @Test
	 public void a_insert() throws Exception {
		 
		 UserTbl user = new UserTbl(201,"aac","123","Activated","USER");
		 userDao.insertUser(user);
	 }

	 @Test
	 public void b_findById() throws Exception {
		 UserTbl user = userDao.getUserById(201);
		 System.out.println("User Name is: "+user.getUsername());
		 assertTrue(user.getId()==201);
	 }
	
	 @Test
	 public void c_findByName() throws Exception {
		 UserDetails userp = userDao.loadUserByUsername("aac");
		 System.out.println("User Name is: "+userp.getUsername());
		 assertTrue(userp.getUsername().equals("aac"));
	 }
	 
	 @Test
	 public void d_updateUser() throws Exception {
		 UserTbl user = new UserTbl(201,"aac","22345","Deactivated","USER");
		 userDao.updateUser(user);
	 }

	 @Test
	 public void e_deleteUser() throws Exception {
		 
		 userDao.deleteUser(201);
	 }
	 
	 @Test
	 public void f_insert() throws Exception {
		 
		 UserTbl user = new UserTbl(201,"aac","123","Activated","USER");
		 userDao.insertUser(user);
	 }
}
