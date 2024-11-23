package tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import drivers.DriverProvider;
import screens.CartsScreen;
import screens.LoginScreen;
import screens.ProductDetailsScreen;
import screens.ProductsScreen;

public class CartsTest extends BaseTest {
	
	@BeforeClass
	public void startServer() throws MalformedURLException {
		driver = DriverProvider.createAppiumDriver("Android", "emulator-5556");
	}

	@Test(priority=1)
	public void addToCartTest() {
		new ProductsScreen(driver).selectProduct("Sauce Labs Backpack");
		new ProductDetailsScreen(driver).selectCountAndAddToCart(2);
		Assert.assertTrue(new ProductDetailsScreen(driver).validateCartCount(2), "Cart count is not matching");
	}

	@Test(priority=2)
	public void gotoCartTest() {
		new ProductDetailsScreen(driver).gotoCart();
		Assert.assertTrue(new CartsScreen(driver).validateCartScreenIsVisible(), "Cart screen is not visible");
	}

	@Test(priority=3)
	public void checkoutPageTest() {
		new CartsScreen(driver).proceedCheckOut();
		Assert.assertTrue(new LoginScreen(driver).validateLoginScreenIsDisplayed(), "Login screen is not shown");
	}

	@Test(priority=4)
	public void shippingDetailsTest() throws InterruptedException {
		new LoginScreen(driver).enterUserName("bob@example.com");
		new LoginScreen(driver).enterPassword("10203040");
		new LoginScreen(driver).clickLoginBtn();
		new CartsScreen(driver).enterShippingDetails("Gokul Saminathan", "Chengappalli", "Tiurppur", "638812", "India");
		new CartsScreen(driver).makePayment();
		new CartsScreen(driver).enterPaymentDetails("Gokul Saminathan", "1234567898765432", "06/28", "527");
		new CartsScreen(driver).reviewOrder();
		new CartsScreen(driver).placeOrder();
		Assert.assertTrue(new CartsScreen(driver).validateCompletedOrder(),"Order is not placed successfully");
	}

}
