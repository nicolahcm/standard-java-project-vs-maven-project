package scheduler.tasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


import scheduler.config.Config;

public class InsertRow {
private final String SQL_INSERT = "INSERT INTO product (data_creazione) VALUES (?)";
	

	
    public String createRow() throws FileNotFoundException, IOException {
    	
    	Config config = new Config();
    	
    	try (Connection conn = DriverManager.getConnection(
                config.getUrl(), config.getUser(), config.getPassword());
        		PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
        
            if (conn != null) {
                System.out.println("Connected to the database!");
                
                preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
          
                int row = preparedStatement.executeUpdate();
                
                return "new row " + row + " inserted!";
                
            } else {
                System.out.println("Failed to make connection!");
                return "failed to execute task insert row";
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return "failed to execute task insert row";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed to execute task insert row";
        }
 
    }
}
