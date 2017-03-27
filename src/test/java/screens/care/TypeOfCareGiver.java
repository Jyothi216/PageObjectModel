package screens.care;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.screenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TypeOfCareGiver extends screenBase {
	
	public TypeOfCareGiver(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(id="com.care.android.careview:id/providerServicesHeaderText")
	public WebElement headerText;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Tutor\")")
	public WebElement tutor;
	
	public void selectTypeOfCare(){
		tutor.click();
		
	}
	public String getCareTypeHeader(){
		
		waitForElementPresent(10, "com.care.android.careview:id/providerServicesHeaderText");
		return headerText.getText();
	}

}
