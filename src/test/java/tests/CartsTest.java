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
		new ProductsScreen().selectProduct("Sauce Labs Backpack");
		new ProductDetailsScreen().selectCountAndAddToCart(2);
		Assert.assertTrue(new ProductDetailsScreen().validateCartCount(2), "Cart count is not matching");
	}

	@Test(priority=2)
	public void gotoCartTest() {
		new ProductDetailsScreen().gotoCart();
		Assert.assertTrue(new CartsScreen().validateCartScreenIsVisible(), "Cart screen is not visible");
	}

	@Test(priority=3)
	public void checkoutPageTest() {
		new CartsScreen().proceedCheckOut();
		Assert.assertTrue(new LoginScreen().validateLoginScreenIsDisplayed(), "Login screen is not shown");
	}

	@Test(priority=4)
	public void shippingDetailsTest() throws InterruptedException {
		new LoginScreen().enterUserName("bob@example.com");
		new LoginScreen().enterPassword("10203040");
		new LoginScreen().clickLoginBtn();
		new CartsScreen().enterShippingDetails("Gokul Saminathan", "Chengappalli", "Tiurppur", "638812", "India");
		new CartsScreen().makePayment();
		new CartsScreen().enterPaymentDetails("Gokul Saminathan", "1234567898765432", "06/28", "527");
		new CartsScreen().reviewOrder();
		new CartsScreen().placeOrder();
		Assert.assertTrue(new CartsScreen().validateCompletedOrder(),"Order is not placed successfully");
	}

}
