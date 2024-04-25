package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String path = "C:\\Users\\deven\\eclipse-workspace\\CucumberFramework\\Config\\config.properties";
	
	public ReadConfig() {
		properties = new Properties();
		
		try {
			FileInputStream fip = new FileInputStream(path);
			properties.load(fip);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		if (value != null) {
			return value;
		}
		else {
			throw new RuntimeException("URL not specified in config file");
		}
	}
	
}
