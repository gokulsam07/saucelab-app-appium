package tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import drivers.DriverProvider;
import screens.HamMenuScreen;
import screens.LoginScreen;
import screens.LogoutScreen;

public class LogoutTest extends BaseTest {
	@BeforeClass
	public void startServer() throws MalformedURLException {
		driver = DriverProvider.createAppiumDriver("Android", "emulator-5554");
	}
	@Test(priority=1)
	public void logOutMessgaeTest() {
		new HamMenuScreen(driver).clickHamburgerMenu();
		new HamMenuScreen(driver).clickMenu("Log Out");
		Assert.assertTrue(new LogoutScreen(driver).validateLogoutMessgaeIsDisplayed(),"Logout messgae is not displayed");		
	}
	
	@Test(priority=2)
	public void logOutTest() {
		new LogoutScreen(driver).clickLogout();
		new LogoutScreen(driver).validateSuccessfulLogoutAndClose();
		Assert.assertTrue(new LoginScreen(driver).validateLoginScreenIsDisplayed(), "Login screen is not visible");
	}

}
