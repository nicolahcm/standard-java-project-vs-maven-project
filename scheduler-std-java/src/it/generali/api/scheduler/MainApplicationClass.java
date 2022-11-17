package it.generali.api.scheduler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.log4j.Logger;

import it.generali.api.scheduler.conf.Config;
import it.generali.api.scheduler.tasks.InsertRow;
import it.generali.api.scheduler.tasks.SelectRows;
import it.generali.api.scheduler.tasks.UpdateElaborato;


public class MainApplicationClass {
	
	public MainApplicationClass() {
		super();
	}
	
	private static final Logger logger = Logger.getLogger(MainApplicationClass.class);

	public static void main(String[] args) {
		
		SelectRows selectRows = new SelectRows();
		InsertRow insertRow = new InsertRow();
		UpdateElaborato updateElaborato = new UpdateElaborato();
		
		
		try {if(args!=null) {
			switch(args[0]) {
			case "0":
				insertRow.createRow();
				break;
			case "1":
				updateElaborato.updateRows();
				break;
			default:
				selectRows.selectRowsWhereElaboratoIsNull();
				break;
			}
		}} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		

	}

}
