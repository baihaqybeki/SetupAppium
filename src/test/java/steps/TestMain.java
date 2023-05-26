package steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TestMain{
	
	private static AndroidDriver<MobileElement> driver;
	private Page page;

	@When("open apps")
	public void plus() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "RMX1971");
		cap.setCapability("udid", "e381d3a4");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage","com.coloros.calculator");
		cap.setCapability("appActivity","com.android.calculator2.Calculator");
		cap.setCapability("noReset", true);
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}
	
	@BeforeStep
	public void pageObject(){
		page = new Page(driver);
	}
	
	
	@After
	public void closeApp() {
		driver.quit();
	}
}
