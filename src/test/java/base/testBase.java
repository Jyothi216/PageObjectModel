package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.AppiumServer;
import utility.commonUtils;
import utility.excelReader;

public class testBase {

	
	public static AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile="Android_careapp.properties";
	public static excelReader excel= new excelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\TestData.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");	
    
	@BeforeSuite
	public void setUp() throws IOException{
		
		if (driver == null) {
			AppiumServer.start();
			log.debug("Appium server started");

			if (loadPropertyFile.startsWith("IOS")) {

				//log.debug("Starting on IOS");
				/*
				 * CommonUtils.loadIOSConfigProp(loadPropertyFile);
				 * CommonUtils.setIOSCapabilities(); driver =
				 * CommonUtils.getIOSDriver();
				 */

			} else if (loadPropertyFile.startsWith("Android")) {

				log.debug("Starting on Android");
				commonUtils.loadAndroidConfProp(loadPropertyFile);
				commonUtils.setAndroidCapabilities();
				driver = commonUtils.getAndroidDriver();
			}

		}

	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException{
		
		driver.quit();
		AppiumServer.stop();
		log.debug("appium server stopped");
		
		
		
		
	}
}
