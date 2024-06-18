package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySqlDBConnection{

	// Access args of propertie files
	private static ResourceBundle rb = ResourceBundle.getBundle("database");

	//Access to mysqlconnectorXXXX.java class
	static{
			  try{
						 Class.forName(rb.getString("driver"));
			  }
			  catch(ClassNotFoundException e){
						 e.printStackTrace();
			  }
	}

	//Conecction Method

	public static Connection getCn(){
			  Connection out = null;
			  try{
						 out = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
			  }catch(SQLException se){
						 se.printStackTrace();
			  }
		return out;
	}
}
