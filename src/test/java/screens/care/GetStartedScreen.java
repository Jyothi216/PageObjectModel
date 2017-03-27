package screens.care;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.screenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GetStartedScreen extends screenBase{
	
	@AndroidFindBy(id="com.care.android.careview:id/seeker_enrollment_layout")
	public  WebElement careGiver;

	
	public GetStartedScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		// TODO Auto-generated constructor stub
	}
	
	public  TypeOfCareGiver hireACareGiver(){
		careGiver.click();
		return new TypeOfCareGiver(driver);
		
	}
	
	public static void findACareJob(){
		
	}
	
	
	
	

}
