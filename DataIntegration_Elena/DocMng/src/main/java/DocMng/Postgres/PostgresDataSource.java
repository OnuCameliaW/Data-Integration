package DocMng.Postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PostgresDataSource {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "org.postgresql.Driver";  
	   static final String DB_URL = "jdbc:postgresql://localhost:5432/DocMng";

	   //  Database credentials
	   static final String USER = "postgres";
	   static final String PASS = "postgres";
	   
	   public Connection getConnection() throws Exception{
		   
		   Class.forName(JDBC_DRIVER);
		   
		   Properties props = new Properties();
		   props.setProperty("user", USER);
		   props.setProperty("password", PASS);
		   
		   // props.setProperty("ssl","true");
		   
		   Connection conn = DriverManager.getConnection(DB_URL, props);
		   return conn;
	   }
}
