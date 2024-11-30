package screens;

import static com.codeborne.selenide.Selenide.$x;
import static elementutils.LocateStrategy.getLocator;

import com.codeborne.selenide.appium.AppiumClickOptions;

public class ProductDetailsScreen {
	
	public ProductDetailsScreen() {
		
	}

	private static String INC_COUNTER_AN = "//*[@content-desc='counter plus button']";
	private static String INC_COUNTER_IOS = "//*[@content-desc='counter plus button']";
	//private static String DEC_COUNTER_AN = "//*[@content-desc='counter minus button']";
	//private static String DEC_COUNTER_IOS = "//*[@content-desc='counter minus button']";
	private static String ADD_AN = "//*[@text='Add To Cart']";
	private static String ADD_IOS = "//*[@text='Add To Cart']";
	private static String GOTOCART_AN = "//*[@content-desc='cart badge']";
	private static String GOTOCART_IOS = "//*[@content-desc='cart badge']";

	public void selectCountAndAddToCart(int count) {
		if (count == 1) {
			$x(getLocator(ADD_AN, ADD_IOS)).click();
		} else {
			int localCounter = 1;
			while (localCounter < count) {
				$x(getLocator(INC_COUNTER_AN, INC_COUNTER_IOS)).click();
				localCounter++;
			}
			$x(getLocator(ADD_AN, ADD_IOS)).click();
		}
	}
	public boolean validateCartCount(int count) {
		return $x(getLocator("//*[@text='"+count+"']", "//*[@text='"+count+"']")).isDisplayed();
	}
	
	public void gotoCart() {
		$x(getLocator(GOTOCART_AN, GOTOCART_IOS)).click(AppiumClickOptions.tap());
	}
}
