package employee.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	 Connection c;
	  Statement s;
	public Conn() {
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
		   c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","oracle");
	      s=c.createStatement();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		

	}

}
