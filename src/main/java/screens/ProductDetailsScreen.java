package screens;

import org.openqa.selenium.WebDriver;
import static elementutils.LocateStrategy.*;

public class ProductDetailsScreen {
	public WebDriver driver = null;

	public ProductDetailsScreen(WebDriver driver) {
		this.driver = driver;
	}

	private static String INC_COUNTER_AN = "//*[@content-desc='counter plus button']";
	private static String INC_COUNTER_IOS = "//*[@content-desc='counter plus button']";
	private static String DEC_COUNTER_AN = "//*[@content-desc='counter plus button']";
	private static String DEC_COUNTER_IOS = "//*[@content-desc='counter plus button']";
	private static String ADD_AN = "//*[@text='Add To Cart']";
	private static String ADD_IOS = "//*[@text='Add To Cart']";
	private static String GOTOCART_AN = "//*[@content-desc='cart badge']";
	private static String GOTOCART_IOS = "//*[@content-desc='cart badge']";

	public void selectCountAndAddToCart(int count) {
		if (count == 1) {
			getElementByXPath(driver, ADD_AN, ADD_IOS).click();
		} else {
			int localCounter = 1;
			while (localCounter < count) {
				getElementByXPath(driver, INC_COUNTER_AN, INC_COUNTER_AN).click();
				localCounter++;
			}
			getElementByXPath(driver, ADD_AN, ADD_IOS).click();
		}
	}
	public boolean validateCartCount(int count) {
		return getElementByXPath(driver,"//*[@text='"+count+"']", "//*[@text='"+count+"']").isDisplayed();
	}
	
	public void gotoCart() {
		getElementByXPath(driver, GOTOCART_AN, GOTOCART_IOS).click();
	}
}
