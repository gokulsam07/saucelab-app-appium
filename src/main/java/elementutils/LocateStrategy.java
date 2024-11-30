package elementutils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.appium.AppiumDriverRunner;

import io.appium.java_client.AppiumBy;

public class LocateStrategy {

	public LocateStrategy() {
	}

	public static WebElement getElementByXPath(String androidBy, String iosBy) {
		//from selenium one can get the same thing by using ((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")
		
		if (AppiumDriverRunner.isAndroidDriver()) {
			try{
				$x(androidBy).isDisplayed();
			}catch(Exception e) {
				scrollToViewUiSelector(androidBy);
			}
			return $x(androidBy);
		} else {
			return $x(iosBy);
		}
	}

	public static WebElement getElementByID(WebDriver driver, String androidBy, String iosBy) {
		if (AppiumDriverRunner.isAndroidDriver()) {
			return $(id(androidBy));
		} else {
			return $(id(iosBy));
		}
	}
	
	public static WebElement getElementByAccID(WebDriver driver, String androidBy, String iosBy) {
		if (AppiumDriverRunner.isAndroidDriver()) {
			return $(AppiumBy.accessibilityId(androidBy));
		} else {
			return $(AppiumBy.accessibilityId(iosBy));
		}
	}

	public static WebElement getElementByName(WebDriver driver, String androidBy, String iosBy) {
		if (AppiumDriverRunner.isAndroidDriver()) {
			return $(name(androidBy));
		} else {
			return $(name(iosBy));
		}
	}

	public static WebElement getElementByClassName(WebDriver driver, String androidBy, String iosBy) {
		if (AppiumDriverRunner.isAndroidDriver()) {
			return $(className(androidBy));
		} else {
			return $(className(iosBy));
		}

	}

	public static ElementsCollection getElementsByXPath(WebDriver driver, String androidBy, String iosBy) {
		if (AppiumDriverRunner.isAndroidDriver()) {
			return $$x(androidBy);
		} else {
			return $$x(iosBy);
		}
	}

	public static ElementsCollection getElementsByID(WebDriver driver, String androidBy, String iosBy) {
		if (AppiumDriverRunner.isAndroidDriver()) {
			return $$(id(androidBy));
		} else {
			return $$(id(iosBy));
		}
	}

	public static ElementsCollection getElementsByName(WebDriver driver, String androidBy, String iosBy) {
		if (AppiumDriverRunner.isAndroidDriver()) {
			return $$(name(androidBy));
		} else {
			return $$(name(iosBy));
		}
	}

	public static ElementsCollection getElementsByClassName(WebDriver driver, String androidBy, String iosBy) {
		if (AppiumDriverRunner.isAndroidDriver()) {
			return $$(className(androidBy));
		} else {
			return $$(className(iosBy));
		}

	}
	//Reference for scrollToViewUiSelector
	//github.com/appium/appium-uiautomator2-server/blob/master/app/src/test/java/io/appium/uiautomator2/utils/UiScrollableParserTests.java
	//github.com/appium/appium-uiautomator2-driver/blob/master/docs/uiautomator-uiselector.md
	
	public static void scrollToViewUiSelector(String path) {
		Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(path);
        String value=null;
        if (matcher.find()) {
           value = matcher.group(1);
        }
		$(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+value+"\"));"));

	}
	public static String getLocator(String android,String ios) {
		return AppiumDriverRunner.isAndroidDriver()?android:ios;
	}
}
