import connect.Connect2DB;

import java.sql.*;
public class test {
	public static void main(String[] args) throws Exception{
		Connection con = new Connect2DB().getConnection();
		Statement sta = con.createStatement();
		sta.executeUpdate("drop table we");
		con.close();
	}
}
