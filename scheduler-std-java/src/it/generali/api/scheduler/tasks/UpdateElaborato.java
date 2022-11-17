package it.generali.api.scheduler.tasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import it.generali.api.scheduler.conf.Config;
import it.generali.api.scheduler.utils.DbUtils;

public class UpdateElaborato {

	private final String UPDATE_SQL = "update product set elaborato='Y', data_elaborazione=? where elaborato is null;";
	
	
	public void updateRows() throws FileNotFoundException, IOException, SQLException, Exception {
		
		Config config = new Config();
		
		Connection conn =  DbUtils.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_SQL);
	
		preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
        preparedStatement.executeUpdate();

        DbUtils.closePreparedStmt(preparedStatement);
        DbUtils.closeConnection(conn);
        
		
	}
	
	
}
