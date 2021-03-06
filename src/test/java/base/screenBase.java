package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class screenBase {
	
	public AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	
	public void waitForElementPresent(long duration, String locator){
		
		wait= new WebDriverWait(driver,duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
		
	}
	
	public screenBase(AppiumDriver<MobileElement> driver){
		
		this.driver=driver;
	}

	

}
