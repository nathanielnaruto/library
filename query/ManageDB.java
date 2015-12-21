package query;

import java.sql.*;
import exception.*;
import main.Global;

public class ManageDB {
	public ManageDB() {
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/library";
			String user = "library";
			String pass = "123456";
			con = DriverManager.getConnection(
							url, user, pass);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void insertBook(String filePath) throws Exception {
		Statement stmt = con.createStatement();
		
	}
	public void insertBook(String bno, String type, String title, String publisher, int year, String author, double price, int total, int stock) throws BookExistException, SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from book where bno = '" + bno + "'");
		if (rs.next() != false) {
			throw new BookExistException();
		}
		String sql = "insert into book values('" + bno + "', '" + type + "', '" + 
						title + "', '" + publisher + "', " + year + ", '" + author + "', " + 								price + ", " + total +  ", " + stock + ")";
//		System.out.println(sql);
		stmt.executeUpdate(sql);	
	}
	public void addCard(String cno, String name, String department, String type) throws CardExistException, SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from card where cno = '" + cno + "'");
		if (rs.next() != false) {
			throw new CardExistException();
		}
		String sql = "insert into card values('" + cno + "', '" + name + "', '" + 
						department + "', '" + type + "')";
//		System.out.println(sql);
		stmt.executeUpdate(sql);
	}
	public void deleteCard(String cno) throws CardNotExistException, SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from card where cno = '" + cno + "'");
		if (rs.next() == false) {
			throw new CardNotExistException();
		}
		String sql = "delete from card where cno = '" + cno + "'";
//		System.out.println(sql);
		stmt.executeUpdate(sql);
	}
	
	public void isAdmin(String username, String password) throws FailLoginException, SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select password from handler where hno = '"
										 + username + "'");
		while (rs.next()) {
			if (password.equals(rs.getString(1))) {
				Global.setHandle(username);
				return;
			}
		}
		throw new FailLoginException();
	}
	
	public void isReader(String username) throws FailLoginException, SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select password from card where cno = '"
										 + username + "'");
		if (rs.next() != false) return;
		throw new FailLoginException();
	}
	
	
	public void borrow(String cno, String bno, String borrowDate, String returnDate, String hno) throws BookOutException, SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select stock from book where bno = '"
										 + bno + "'");
		while (rs.next()) {
			if (rs.getInt(1) == 0) throw new BookOutException();
		}
		String sql = "insert into borrow values('" + cno + "', '" + bno + "', '" + 
						borrowDate + "', '" + returnDate + "', '" + hno + "')";
		stmt.executeUpdate(sql);
	}
	public void close() {
		try {
			con.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	private Connection con;

}
