package Pages;
	
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class Baseclass {
	
	public static Properties properties = null;
	public static WebDriver driver;
	
	public Properties loadPropertyFile() throws IOException{
		    FileInputStream readingObj = new FileInputStream("Object.properties");
		    properties  = new Properties();
		    properties.load(readingObj);
		return properties;
	}
	@BeforeSuite
	public void launchBrowser() throws IOException {
		loadPropertyFile();
	}
	

}
