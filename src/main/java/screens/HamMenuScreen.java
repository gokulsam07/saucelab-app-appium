package screens;

import static com.codeborne.selenide.Selenide.$x;
import static elementutils.LocateStrategy.getLocator;

public class HamMenuScreen {
	public HamMenuScreen() {
	}
	
	private static String HAM_MENU_AN = "//*[@content-desc='open menu']";
	private static String HAM_MENU_IOS = "//*[@content-desc='open menu']";
	
	
	public void clickHamburgerMenu() {
		$x(getLocator(HAM_MENU_AN, HAM_MENU_IOS)).click();
	}
	
	public void clickMenu(String menu) { 
		$x(getLocator("//*[@text='"+menu+"']", "//*[@text='"+menu+"']")).click();
	}

}
