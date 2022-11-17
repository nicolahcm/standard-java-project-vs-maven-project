package it.generali.api.scheduler.tasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.generali.api.scheduler.conf.Config;
import it.generali.api.scheduler.utils.DbUtils;

public class SelectRows {
	
	private final String SQL_SELECT = "SELECT idproduct, data_creazione FROM product WHERE elaborato IS NULL;";

	
	public void selectRowsWhereElaboratoIsNull() throws FileNotFoundException, IOException, SQLException, Exception {
		
		Connection conn = DbUtils.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
		ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            long id = resultSet.getLong("idproduct");
            Date date = resultSet.getDate("data_creazione");
            System.out.println("id is " + id + " and date is " + date);
        }

        DbUtils.closeResultSet(resultSet);
        DbUtils.closePreparedStmt(preparedStatement);
        DbUtils.closeConnection(conn);
        
        
	}
}
