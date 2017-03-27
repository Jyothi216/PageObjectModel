package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class testCare {
	public static AndroidDriver<MobileElement> driver;
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriverLocalService service= AppiumDriverLocalService.
				buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
				.withLogFile(new File("C:\\Users\\Jyothi\\Desktop\\log.txt")));
		service.start();
		DesiredCapabilities capabilities= new DesiredCapabilities();		
		//File app = new File("C:\\Users\\Jyothi\\Desktop\\test.apk");
		capabilities.setCapability("deviceName","ASUS");
		capabilities.setCapability("appPackage", "com.care.android.careview");
		capabilities.setCapability("appActivity", "com.care.android.careview.ui.startup.SplashActivity");
		//capabilities.setCapability("app", app.getAbsolutePath());
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.findElementById("com.care.android.careview:id/sign_up_email").click();
		driver.findElementById("com.care.android.careview:id/seeker_enrollment_layout").click();
		String text= "Tutor";
		String actual_text=driver.findElementById("com.care.android.careview:id/providerServicesHeaderText").getText();
		//Assert.assertTrue(actual_text.contains("I AM LOOKING FOR"));
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")").click();
		driver.findElementById("com.care.android.careview:id/email").sendKeys("uat.tester16@gmail.com");
		driver.findElementById("com.care.android.careview:id/password").sendKeys("jyo476@T");
		driver.findElementById("com.care.android.careview:id/seeker_first_name").sendKeys("Jyothi");
		driver.findElementById("com.care.android.careview:id/seeker_last_name").sendKeys("jdfkk");
		driver.findElementById("com.care.android.careview:id/seeker_birthday").sendKeys("01/01/1993");
		driver.findElementById("com.care.android.careview:id/seeker_optional_msg").click();
		driver.findElementsById("android:id/text1").get(2).click();
		Thread.sleep(2000);
		
		
		driver.quit();
		service.stop();
}
}
