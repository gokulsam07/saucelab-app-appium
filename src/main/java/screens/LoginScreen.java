package screens;

import static com.codeborne.selenide.Selenide.$x;
import static elementutils.LocateStrategy.getLocator;

public class LoginScreen {
	public LoginScreen() {
	}
	
	private static String USER_NAME_AN = "//*[@content-desc='Username input field']";
	private static String USER_NAME_IOS = "//*[@content-desc='Username input field']";
	private static String PASSWORD_AN = "//*[@content-desc='Password input field']";
	private static String PASSWORD_IOS = "//*[@content-desc='Password input field']";
	private static String LOGIN_BTN_AN = "//*[@content-desc='Login button']";
	private static String LOGIN_BTN_IOS = "//*[@content-desc='Login button']";
	
	
	public void enterUserName(String userName) {
		$x(getLocator(USER_NAME_AN, USER_NAME_IOS)).sendKeys(userName);
	}
	public void enterPassword(String pwd) {
		$x(getLocator(PASSWORD_AN, PASSWORD_IOS)).sendKeys(pwd);
	}
	public void clickLoginBtn() {
		$x(getLocator(LOGIN_BTN_AN, LOGIN_BTN_IOS)).click();
	}
	
	public boolean validateLoginScreenIsDisplayed() {
		return $x(getLocator(USER_NAME_AN, USER_NAME_IOS)).isDisplayed();
	}
}
