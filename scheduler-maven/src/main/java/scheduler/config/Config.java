package scheduler.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Config {
	
	private final Properties prop;
	private static final String DEFAULT = "missing";

	public Config() throws FileNotFoundException, IOException {
		super();
		this.prop = new Properties();
		this.prop.load(new FileInputStream(System.getProperty("appProperties")));
	}
	
	public String getUrl() {
		String url = this.prop.getProperty("jdbc.mysql.url", DEFAULT);
		return url;
	}

	public String getUser() {
		String user = this.prop.getProperty("jdbc.mysql.user", DEFAULT);
		return user;
	}
	
	public String getPassword() {
		String password = this.prop.getProperty("jdbc.mysql.pass", DEFAULT);
		return password;
	}
	
}
