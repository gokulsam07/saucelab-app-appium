package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import appiumutils.AppiumServerInitializer;
import drivers.DriverProvider;

public class BaseTest {
	
	@BeforeTest
	public void startAppiumServer() {
		AppiumServerInitializer.startAppiumServer(2381);
		AppiumServerInitializer.startAppiumServer(2382);
	}
	
	@AfterClass
	public void closeDriver() {
		DriverProvider.remove();
	}
	
	@AfterTest
	public void shutdownAppiumServer() {
		AppiumServerInitializer.killAppiumServer(2381);
		AppiumServerInitializer.killAppiumServer(2382);
	}
	
}
