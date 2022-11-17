package it.generali.api.scheduler.tasks;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

import it.generali.api.scheduler.conf.Config;
import it.generali.api.scheduler.utils.DbUtils;

public class InsertRow {
	
	private final String SQL_INSERT = "INSERT INTO product (data_creazione) VALUES (?)";
	

	
    public void createRow() throws FileNotFoundException, IOException, SQLException, Exception {
    	
    	Connection conn = DbUtils.getConnection();
    	PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);
             
        preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
        preparedStatement.executeUpdate();

        DbUtils.closePreparedStmt(preparedStatement);
        DbUtils.closeConnection(conn);
        

    }

}
