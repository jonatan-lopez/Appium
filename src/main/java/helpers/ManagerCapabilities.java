package helpers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ManagerCapabilities {
	private static Properties prop = new Properties();

	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static AndroidDriver driver;

	public static void loadConfigProp(){
		
		String userDir = System.getProperty("user.dir");
		try {
		FileInputStream fis = new FileInputStream(userDir + "/src/main/resources/app.properties");
		prop.load(fis);
		}catch (IOException e) {
			System.err.print("File not found");
		}
		setCapabilities();
		
	}

	private static void setCapabilities() {
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
		capabilities.setCapability("platformVersion", prop.getProperty("version"));
		capabilities.setCapability("platformName", prop.getProperty("platform"));
		capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
		capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
		capabilities.setCapability("chromedriverExecutable","./src/main/resources/chromedriver");

	}

	public static AndroidDriver getDriver() throws MalformedURLException {
		return getAndroidDriver();
	}

	public static AndroidDriver getAndroidDriver() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://localhost:" + 4723 + "/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
