package screens;

import org.openqa.selenium.WebDriver;

import static elementutils.LocateStrategy.*;

public class HamMenuScreen {
	public WebDriver driver =null;
	public HamMenuScreen(WebDriver driver) {
		this.driver=driver;
	}
	
	private static String HAM_MENU_AN = "//*[@content-desc='open menu']";
	private static String HAM_MENU_IOS = "//*[@content-desc='open menu']";
	
	
	public void clickHamburgerMenu() {
		getElementByXPath(driver,HAM_MENU_AN, HAM_MENU_IOS).click();
	}
	
	public void clickMenu(String menu) { 
		getElementByXPath(driver,"//*[@text='"+menu+"']", "//*[@text='"+menu+"']").click();
	}

}
