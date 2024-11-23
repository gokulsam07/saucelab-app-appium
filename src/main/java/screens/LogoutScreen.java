package screens;

import static elementutils.LocateStrategy.*;
import org.openqa.selenium.WebDriver;

public class LogoutScreen {

	public WebDriver driver = null;

	public LogoutScreen(WebDriver driver) {
		this.driver = driver;
	}

	private static String LOGOUT_MSG_AN = "//*[@text='Are you sure you sure you want to logout?']";
	private static String LOGOUT_MSG_IOS = "//*[@text='Are you sure you sure you want to logout?']";
	private static String LOGOUT_AN = "android:id/button1";
	private static String LOGOUT_IOS = "android:id/button1";
	private static String POST_LOGOUT_MSG_AN = "//*[@text='You are successfully logged out.']";
	private static String POST_LOGOUT_MSG_IOS = "//*[@text='You are successfully logged out.']";
	private static String OK_AN = "android:id/button1";
	private static String OK_IOS = "android:id/button1";

	public boolean validateLogoutMessgaeIsDisplayed() {
		return getElementByXPath(driver, LOGOUT_MSG_AN, LOGOUT_MSG_IOS).isDisplayed();
	}

	public void clickLogout() {
		getElementByID(driver, LOGOUT_AN, LOGOUT_IOS).click();
	}

	public boolean validateSuccessfulLogoutAndClose() {
		boolean isMsgVisible = getElementByXPath(driver,POST_LOGOUT_MSG_AN,POST_LOGOUT_MSG_IOS).isDisplayed();
		getElementByID(driver, OK_AN, OK_IOS).click();
		return isMsgVisible;
	}

}
