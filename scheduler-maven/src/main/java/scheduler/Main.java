package scheduler;

import java.io.IOException;

import scheduler.tasks.InsertRow;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		InsertRow insertRow = new InsertRow();
		
		try {
			insertRow.createRow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
