package tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import drivers.DriverProvider;
import screens.HamMenuScreen;
import screens.LoginScreen;
import screens.ProductsScreen;

public class LoginTest extends BaseTest {
	
	@BeforeClass
	public void startServer() throws MalformedURLException {
		driver = DriverProvider.createAppiumDriver("Android", "emulator-5554");
	}
	
	@Test(priority=1)
	public void loginPageTest() {
		new HamMenuScreen().clickHamburgerMenu();
		new HamMenuScreen().clickMenu("Log In");
	}
	
	@Test(priority=2)
	public void enterLoginCredentials() {
		new LoginScreen().enterUserName("bob@example.com");
		new LoginScreen().enterPassword("10203040");
		new LoginScreen().clickLoginBtn();
	}
	
	@Test(priority=3)
	public void validateProductScreenIsVisiblePostLogin() {
		Assert.assertTrue(new ProductsScreen().validateProductsScreensisVisible(),"Product screen is not visible");
	}

}
