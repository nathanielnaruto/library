package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect2DB {
	public static void makeConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/library";
		String user = "library";
		String pass = "123456";
		connection = DriverManager.getConnection(
						url, user, pass);
	}
	public static Connection getConnection() {
		//return the connection to the user
		return connection;
	}
	private static Connection connection;
}

