package it.generali.api.scheduler.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.generali.api.scheduler.conf.Config;

public class DbUtils {
	

	
	
	public static Connection getConnection() throws SQLException, IOException, Exception {
		Config config = new Config();
		Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
		return conn;
	}
	
	public static void closeConnection(Connection conn) throws Exception {
		conn.close();
	}
	
	public static void closePreparedStmt(PreparedStatement prepStms) throws Exception {
		prepStms.close();
	}
	
	public static void closeResultSet(ResultSet resSet) throws Exception {
		resSet.close();
	}
	
	
}
