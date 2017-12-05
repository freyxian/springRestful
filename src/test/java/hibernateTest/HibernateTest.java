package hibernateTest;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.uxpsystems.assignment.entity.UserTbl;

public class HibernateTest {
	private FileSystemXmlApplicationContext ctx = null;

	@Ignore
	@Test
	public void testDataSource() throws SQLException {

		ctx = new FileSystemXmlApplicationContext(
				"C:\\D-Drive\\Documents\\testing\\uxp\\assignment\\assignment\\src\\main\\webapp\\WEB-INF\\assignment-servlet.xml");
		// ctx.setConfigLocation("/WEB-INF/assignment-servlet.xml");
		// ctx.setServletContext(request.getServletContext());
		// ctx.refresh();

		DataSource dataSource = ctx.getBean(DataSource.class);

		// System.out.println(dataSource.getConnection().toString());
		// ���hibernate����
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// �������ݿ�
		// UserTbl(long id, String username, String password,
		// String status, String role)

		UserTbl user = new UserTbl(2, "xjb", "123456", "Activated","USER");
		session.save(user);
		tx.commit();
		session.close();

	}

}
