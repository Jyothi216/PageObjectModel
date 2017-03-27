package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class commonUtils {
	
	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String  BASE_PACKAGE;
	public static String APP_ACTIVITY;
	public static String  BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String  PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String APPIUM_PORT;
	public static String APP_PATH;
	
	private static Properties prop= new Properties();
	private static DesiredCapabilities capabilities= new DesiredCapabilities();
	public static URL serverUrl;
	
	//loadIOSConfProp
	
	private static AppiumDriver<MobileElement> driver;
	
	public static void loadAndroidConfProp(String propertyFileName) throws IOException{
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\"+propertyFileName);
		prop.load(fis);
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		APP_PATH= prop.getProperty("application.path");
		BASE_PACKAGE= prop.getProperty("base.pkg");
		APP_ACTIVITY= prop.getProperty("application.activity");
		BROWSER_NAME= prop.getProperty("browser.name");
		PLATFORM_NAME= prop.getProperty("platform.name");
		PLATFORM_VERSION= prop.getProperty("platform.version");
		DEVICE_NAME= prop.getProperty("device.nmae");
		APPIUM_PORT= prop.getProperty("appium.server.port");
	}
	//setIOSCapabilities
	public static void setAndroidCapabilities(){
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PACKAGE);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
				
	}
	//getIOSDriver
	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException{
		
		serverUrl=new URL("http://localhost:"+APPIUM_PORT+"/wd/hub");
		driver= new AndroidDriver<MobileElement>(serverUrl,capabilities);
		return driver;
		
	}

}
