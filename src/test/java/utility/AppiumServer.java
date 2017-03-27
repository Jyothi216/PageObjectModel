package utility;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
	
	public static AppiumDriverLocalService service;
	
	public static void start(){
		
		AppiumDriverLocalService service= AppiumDriverLocalService.
				buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
				.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\Appium.log")));
		
		//service.start(); src\test\resources\logs\Appium.log
		
	}
	
	public static void stop() throws InterruptedException {
		Thread.sleep(5000);
		
		//service.stop();
		
	}

}
 