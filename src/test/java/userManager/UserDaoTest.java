package userManager;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.UserTbl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/assignment-servlet.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {
	@Autowired
	UserDao userDao;
	
	 @Test
	 public void a_insert() throws Exception {
		 
		 UserTbl user = new UserTbl(101,"aab","123","Activated","USER");
		 //UserDao userDao = (UserDao) context.getBean("com.uxpsystems.assignment.dao.UserDao");
		 userDao.insertUser(user);
	 }
	
	 @Test
	 public void b_findById() throws Exception {
		 UserTbl user = userDao.getUserById(101);
		 System.out.println("User Name is: "+user.getUsername());
		 assertTrue(user.getId()==101);
	 }
	
	 @Test
	 public void c_findByName() throws Exception {
		 UserTbl user = userDao.getUserByName("aab");
		 System.out.println("User Name is: "+user.getUsername());
		 assertTrue(user.getId()==101);
	 }
	 
	 @Test
	 public void d_updateUser() throws Exception {
		 UserTbl user = new UserTbl(101,"abc","12345","Deactivated","USER");
		 userDao.updateUser(user);
	 }
	 
	 @Test
	 public void e_deleteUser() throws Exception {
		 
		 userDao.deleteUser(101);
	 }
}
