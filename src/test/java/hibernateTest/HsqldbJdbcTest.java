package hibernateTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Ignore;
import org.junit.Test;

public class HsqldbJdbcTest {
	@Ignore
	@Test
	public void HsqlDBTest() throws SQLException {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}

		Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/UXPTestDB", "SA", "");
		Statement stmt = c.createStatement();
		int result = stmt.executeUpdate("INSERT INTO user_tbl VALUES (100,'xja', 'password' )");
		c.commit();
	}
}
