package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class DBHelper.
 */
public class DBHelper {

	/** The con. */
	Connection con;

	/**
	 * Gets the DB connection.
	 *
	 * @return the DB connection
	 */
	public Connection getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			return con;
		} catch (SQLException se) {
			System.out.println("Error in connection");
		} catch (ClassNotFoundException ce) {
			System.out.println("Error loading Driver class");
		}
		return null;
	}

}
