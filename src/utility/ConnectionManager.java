package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Properties loadPropertiesFile() throws IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		Properties prop = loadPropertiesFile();
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		Class.forName(driver);
		con = DriverManager.getConnection(url);
		return con;
	}
}