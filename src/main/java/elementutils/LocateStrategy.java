package elementutils;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class LocateStrategy {
	public static WebDriver driver = null;
	static WebDriverWait wait =null;

	public LocateStrategy(WebDriver driver) {
		LocateStrategy.driver = driver;
	}

	public static WebElement getElementByXPath(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			try{
				driver.findElement(xpath(androidBy)).isDisplayed();
			}catch(Exception e) {
				scrollToViewUiSelector(driver,androidBy);
			}
			return driver.findElement(xpath(androidBy));
		} else {
			return driver.findElement(xpath(iosBy));
		}
	}

	public static WebElement getElementByID(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			return driver.findElement(id(androidBy));
		} else {
			return driver.findElement(xpath(iosBy));
		}
	}
	
	public static WebElement getElementByAccID(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			return driver.findElement(AppiumBy.accessibilityId(androidBy));
		} else {
			return driver.findElement(AppiumBy.accessibilityId(iosBy));
		}
	}

	public static WebElement getElementByName(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			return driver.findElement(name(androidBy));
		} else {
			return driver.findElement(name(iosBy));
		}
	}

	public static WebElement getElementByClassName(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			return driver.findElement(className(androidBy));
		} else {
			return driver.findElement(className(iosBy));
		}

	}

	public static List<WebElement> getElementsByXPath(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			return driver.findElements(xpath(androidBy));
		} else {
			return driver.findElements(xpath(iosBy));
		}
	}

	public static List<WebElement> getElementsByID(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			return driver.findElements(id(androidBy));
		} else {
			return driver.findElements(xpath(iosBy));
		}
	}

	public static List<WebElement> getElementsByName(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			return driver.findElements(name(androidBy));
		} else {
			return driver.findElements(name(iosBy));
		}
	}

	public static List<WebElement> getElementsByClassName(WebDriver driver, String androidBy, String iosBy) {
		if (((RemoteWebDriver) driver).getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
			return driver.findElements(className(androidBy));
		} else {
			return driver.findElements(className(iosBy));
		}

	}
	//Reference for scrollToViewUiSelector
	//github.com/appium/appium-uiautomator2-server/blob/master/app/src/test/java/io/appium/uiautomator2/utils/UiScrollableParserTests.java
	//github.com/appium/appium-uiautomator2-driver/blob/master/docs/uiautomator-uiselector.md
	
	public static void scrollToViewUiSelector(WebDriver driver,String path) {
		Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(path);
        String value=null;
        if (matcher.find()) {
           value = matcher.group(1);
        }
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+value+"\"));"));

	}
}
