package drivers;

import java.net.MalformedURLException;
import java.net.URL;

import appiumutils.AppiumServerInitializer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class DriverProvider {
	static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

	public static AppiumDriver createAppiumDriver(String platform, String uuid) throws MalformedURLException {
		int port = AppiumServerInitializer.findFreePort(9000);
		AppiumServerInitializer.startAppiumServer(port);
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName(platform);
		options.setUdid(uuid);
		if (platform.equalsIgnoreCase("android")) {
			options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
			options.setApp(System.getProperty("user.dir") + "/apps/DemoApp.apk");
			driver.set(new AndroidDriver(new URL("http://127.0.0.1:"+port+""), options));
		}
		return driver.get();
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
