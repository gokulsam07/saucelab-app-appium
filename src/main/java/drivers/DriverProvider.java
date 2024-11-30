package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import com.codeborne.selenide.WebDriverRunner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

public class DriverProvider {
	static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

	public static AppiumDriver createAppiumDriver(String platform, String uuid) throws MalformedURLException {
		// int port = AppiumServerInitializer.findFreePort(9000);
		// AppiumServerInitializer.startAppiumServer(port)
		if (platform.equalsIgnoreCase("android")) {
			UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName(platform);
			options.setUdid(uuid);
			options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
			options.setApp(System.getProperty("user.dir") + "/apps/DemoApp.apk");
			driver.set(new AndroidDriver(new URL("http://127.0.0.1:" + selectPort() + ""), options));
			WebDriverRunner.setWebDriver(getDriver());
		} else if (platform.equalsIgnoreCase("ios")) {
			XCUITestOptions options = new XCUITestOptions();
		    options.setAutomationName(AutomationName.IOS_XCUI_TEST);
			options.setApp(System.getProperty("user.dir") + "/apps/DemoApp.apk");
			driver.set(new IOSDriver(new URL("http://127.0.0.1:"+selectPort()+""), options));
			WebDriverRunner.setWebDriver(getDriver());
		}
		return driver.get();
	}

	private static int selectPort() {
		final int[] ports = { 2381, 2382 };
		final Random r = new Random();
		// Randomly select a port with equal probability
		return ports[r.nextInt(ports.length)];
	}

	public static AppiumDriver getDriver() {
		return driver.get();
	}

	public static void remove() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
