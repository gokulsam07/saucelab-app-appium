package drivers;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.WebDriverProvider;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import lombok.NonNull;
import lombok.SneakyThrows;

public class IOSProviderSelenide implements WebDriverProvider {

	@Override
	@SneakyThrows
	@NonNull
	public WebDriver createDriver(Capabilities capabilities) {
		//Not thread safe - this is selenide impl for launching driver 

		/*
		 * Configuration.browser = Configuration.browser =
		 * IOSDriverProvider.class.getName(); SelenideAppium.launchApp();
		 */
		XCUITestOptions options = new XCUITestOptions();
	    options.setAutomationName(AutomationName.IOS_XCUI_TEST);
	    options.setWdaLaunchTimeout(Duration.ofMinutes(2));
	    options.setUdid("emulator-5554");
	    options.setFullReset(false);
	    options.setApp(System.getProperty("user.dir") + "/apps/DemoApp.apk");
	    return new IOSDriver(new URL("http://127.0.0.1:2382"), options);
	}

}
