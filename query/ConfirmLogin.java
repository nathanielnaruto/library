package query;

import java.sql.*;
import query.ManageDB;

public class ConfirmLogin {
	public static boolean ifSuccess(String username, String password) {
/*		try {
			Connection con = new Connect2DB().getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from handler");
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
*/		return true;
	}
}
