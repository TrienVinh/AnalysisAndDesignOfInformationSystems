package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLDatabaseConnect {
	private String hostName = "localhost";
	private String userName = "root";
	private String passWord = "";
	private String dataBase = "banhanglaptop";

	public MySQLDatabaseConnect(String hostName, String userName, String passWord, String dataBase) {
		super();
		this.hostName = hostName;
		this.userName = userName;
		this.passWord = passWord;
		this.dataBase = dataBase;
	}

	public MySQLDatabaseConnect() {
		super();

	}

	public MySQLDatabaseConnect(String dataBase) {
		super();
		this.dataBase = dataBase;
	}

	public Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + hostName + ":3306/" + dataBase;
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			return conn;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public boolean executeUpdate(String sql) {
		try {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public ResultSet executeQuery(String sql) {
		try {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
