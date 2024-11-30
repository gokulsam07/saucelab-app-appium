package drivers;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.WebDriverProvider;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import lombok.NonNull;
import lombok.SneakyThrows;

public class AndroidProviderSelenide implements WebDriverProvider {
//Not thread safe - this is selenide impl for launching driver 

	/*
	 * Configuration.browser = Configuration.browser =
	 * AndroidDriverProvider.class.getName(); SelenideAppium.launchApp();
	 */

	@Override
	@SneakyThrows
	@NonNull
	public WebDriver createDriver(Capabilities capabilities) {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setPlatformName("Android");
		options.setUdid("emulator-5556");
		options.setApp(System.getProperty("user.dir") + "/apps/DemoApp.apk");
		return new AndroidDriver(new URL("http://127.0.0.1:2381"), options);
	}

}
