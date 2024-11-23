package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import drivers.DriverProvider;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class BaseTest {
	
	protected AppiumDriver driver = null;
	
	@AfterClass
	public void closeDriver() {
		DriverProvider.remove();
	}
	
}
