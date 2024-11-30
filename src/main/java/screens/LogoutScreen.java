package screens;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static elementutils.LocateStrategy.getLocator;

import org.openqa.selenium.By;

public class LogoutScreen {
	
	public LogoutScreen() {
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
		return $x(getLocator(LOGOUT_MSG_AN, LOGOUT_MSG_IOS)).isDisplayed();
	}

	public void clickLogout() {
		$(By.id(getLocator(LOGOUT_AN, LOGOUT_IOS))).click();
	}

	public boolean validateSuccessfulLogoutAndClose() {
		boolean isMsgVisible = $x(getLocator(POST_LOGOUT_MSG_AN,POST_LOGOUT_MSG_IOS)).isDisplayed();
		$(By.id(getLocator(OK_AN, OK_IOS))).click();
		return isMsgVisible;
	}

}
