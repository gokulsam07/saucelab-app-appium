package screens;

import static elementutils.LocateStrategy.getElementByXPath;

import org.openqa.selenium.WebDriver;

public class LoginScreen {
	public WebDriver driver =null;
	public LoginScreen(WebDriver driver) {
		this.driver=driver;
	}
	
	private static String USER_NAME_AN = "//*[@content-desc='Username input field']";
	private static String USER_NAME_IOS = "//*[@content-desc='Username input field']";
	private static String PASSWORD_AN = "//*[@content-desc='Password input field']";
	private static String PASSWORD_IOS = "//*[@content-desc='Password input field']";
	private static String LOGIN_BTN_AN = "//*[@content-desc='Login button']";
	private static String LOGIN_BTN_IOS = "//*[@content-desc='Login button']";
	
	
	public void enterUserName(String userName) {
		getElementByXPath(driver,USER_NAME_AN, USER_NAME_IOS).sendKeys(userName);
	}
	public void enterPassword(String pwd) {
		getElementByXPath(driver,PASSWORD_AN, PASSWORD_IOS).sendKeys(pwd);
	}
	public void clickLoginBtn() {
		getElementByXPath(driver, LOGIN_BTN_AN, LOGIN_BTN_IOS).click();
	}
	
	public boolean validateLoginScreenIsDisplayed() {
		return getElementByXPath(driver,USER_NAME_AN, USER_NAME_IOS).isDisplayed();
	}
}
