package common;

import java.sql.*;

public class ConnectDB {
	private static Connection con = null;
	private static String url = "jdbc:sqlserver://";
	private static String servername = "DESKTOP-1C1QUJC";
	private static String port = "1433";
	private static String databasename = "BKHN_JAVA";
	private static String user = "sa";
	private static String pass = "123456789";

	public static String getConnectURL() {
		return url + servername + ":" + port 
				+ ";databaseName=" + databasename 
				+ ";user=" + user + "; password=" + pass;
	}
	
	public static Connection getCon() {
		try {
			con = DriverManager.getConnection(getConnectURL());
		} catch (Exception e) {
			con=null;
			e.printStackTrace();
		}
		return con;
	}
	
	public Connection getConn() {
		try {
			con = DriverManager.getConnection(getConnectURL());
		} catch (Exception e) {
			con=null;
			e.printStackTrace();
		}
		return con;
	}
	
}
