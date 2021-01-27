
import helpers.FileUtils;
import helpers.HelperAppiumService;
import helpers.ManagerCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public abstract class BaseTest {
	protected static AndroidDriver driver;
	protected AppiumDriverLocalService appiumService;
	FileUtils fileUtils = new FileUtils();
	
	public void setUp() throws MalformedURLException {
		ManagerCapabilities.loadConfigProp();
		appiumService = HelperAppiumService.appiumServiceInitialize();
		appiumService.start();
		driver = ManagerCapabilities.getDriver();
	}
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		setUp();
	}

	@AfterMethod(alwaysRun = true)
	public void baseTearDown() {
		driver.quit();
		appiumService.stop();
	}

}
