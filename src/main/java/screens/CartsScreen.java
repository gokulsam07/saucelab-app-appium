package screens;

import static elementutils.LocateStrategy.*;

import org.openqa.selenium.WebDriver;

public class CartsScreen {

	public WebDriver driver = null;

	public CartsScreen(WebDriver driver) {
		this.driver = driver;
	}
	private static String CARTTEXT_AN = "//*[@text='My Cart']";
	private static String PAY_AN = "//*[@text='To Payment']";
	private static String REVIEW_AN = "//*[@text='Review Order']";
	private static String ORDER_AN = "//*[@text='Place Order']";
	private static String DONE_AN = "//*[@text='Checkout Complete']";
	private static String PROCEEDCHECKOUT_AN = "//*[@text='Proceed To Checkout']";
	private static String FULLNAME_AN = "android.widget.EditText";
	private static String ADDLIN1_AN = "//*[@content-desc='Address Line 1* input field']";
	private static String CITY_AN = "//*[@content-desc='City* input field']";
	private static String ZIPCODE_AN = "//*[@content-desc='Zip Code* input field']";
	private static String COUNTRY_AN = "//*[@content-desc='Country* input field']";
	private static String CARD_AN = "//*[@content-desc='Card Number* input field']";
	private static String EXPDATE_AN = "//*[@content-desc='Expiration Date* input field']";
	private static String CVV_AN = "//*[@content-desc='Security Code* input field']";

	private static String CARTTEXT_IOS = "//*[@text='My Cart']";
	private static String PAY_IOS = "//*[@text='To Payment']";
	private static String REVIEW_IOS = "//*[@text='Review Order']";
	private static String ORDER_IOS = "//*[@text='Place Order']";
	private static String DONE_IOS = "//*[@text='Checkout Complete']";
	private static String PROCEEDCHECKOUT_IOS = "//*[@text='Proceed To Checkout']";
	private static String FULLNAME_IOS = "android.widget.EditText";
	private static String ADDLIN1_IOS = "//*[@content-desc='Address Line 1* input field']";
	private static String CITY_IOS = "//*[@content-desc='City* input field']";
	private static String ZIPCODE_IOS = "//*[@content-desc='Zip Code* input field']";
	private static String COUNTRY_IOS = "//*[@content-desc='Country* input field']";
	private static String CARD_IOS = "//*[@content-desc='Card Number* input field']";
	private static String EXPDATE_IOS = "//*[@content-desc='Expiration Date* input field']";
	private static String CVV_IOS = "//*[@content-desc='Security Code* input field']";

	public boolean validateCartCount(int count) {
		return getElementByXPath(driver, "//*[@text='" + count + "']", "//*[@text='" + count + "']").isDisplayed();
	}

	public void proceedCheckOut() {
		getElementByXPath(driver, PROCEEDCHECKOUT_AN, PROCEEDCHECKOUT_IOS).click();
	}

	public void enterShippingDetails(String name, String add, String city, String zip, String country) {
		getElementByXPath(driver, ADDLIN1_AN, ADDLIN1_IOS).sendKeys(add);
		getElementByClassName(driver, FULLNAME_AN, FULLNAME_IOS).sendKeys(name);
		getElementByXPath(driver, CITY_AN, CITY_IOS).sendKeys(city);
		getElementByXPath(driver, ZIPCODE_AN, ZIPCODE_IOS).sendKeys(zip);
		getElementByXPath(driver, COUNTRY_AN, COUNTRY_IOS).sendKeys(country);
	}

	public void makePayment() {
		getElementByXPath(driver, PAY_AN, PAY_IOS).click();
	}

	public void enterPaymentDetails(String name, String cardNo, String exp, String cvv) {
		getElementByXPath(driver, FULLNAME_AN, FULLNAME_IOS).sendKeys(name);
		getElementByXPath(driver, CARD_AN, CARD_IOS).sendKeys(cardNo);
		getElementByXPath(driver, EXPDATE_AN, EXPDATE_IOS).sendKeys(exp);
		getElementByXPath(driver, CVV_AN, CVV_IOS).sendKeys(cvv);
	}

	public void reviewOrder() throws InterruptedException {
		getElementByXPath(driver, REVIEW_AN, REVIEW_IOS).click();
		if(getElementByXPath(driver, REVIEW_AN, REVIEW_IOS).isDisplayed()) {
			getElementByXPath(driver, REVIEW_AN, REVIEW_IOS).click();
		}
	}

	public void placeOrder() {
		getElementByXPath(driver, ORDER_AN, ORDER_IOS).click();
	}

	public boolean validateCompletedOrder() {
		return getElementByXPath(driver, DONE_AN, DONE_IOS).isDisplayed();
	}
	
	public boolean validateCartScreenIsVisible() {
		return getElementByXPath(driver, CARTTEXT_AN, CARTTEXT_IOS).isDisplayed();
	}

}
