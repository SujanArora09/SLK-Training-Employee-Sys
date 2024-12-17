package jdbcapp.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {
	public static Connection getDBConnection() {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			Properties properties = new Properties();
//			File file = new File("src/main/resources/application.properties");
//			FileInputStream fis = new FileInputStream(file);
//			properties.load(fis);
//			
//			String url = "jdbc:" + properties.getProperty("db") + "://" + properties.getProperty("dbhostname") 
//			+ properties.getProperty("dbport") + "/" + properties.getProperty("dbname");
//			
//			conn = DriverManager.getConnection(url,properties.getProperty("username"),properties.getProperty("password"));
//		}
//		catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}catch (FileNotFoundException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}catch (IOException e) {
//			// TODO: handle exception
//		}
		return conn;
			
		}
	}

