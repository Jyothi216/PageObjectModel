package testcases.care;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import base.testBase;
import screens.care.GetStartedScreen;
import screens.care.HomeScreen;
import screens.care.TypeOfCareGiver;
import utility.TestUtil;

public class CareLoginTest extends testBase {
	
	
	HomeScreen home;
	GetStartedScreen screen;
	TypeOfCareGiver tc;
	@BeforeTest
	public void init(){
		home = new HomeScreen(driver);
		tc= new TypeOfCareGiver(driver);
	}
	
	@Test(priority=1)
	public void validateButtons(){
		
		System.out.println(home.validateButtonCount());
		//AssertJUnit.assertEquals(3, home.validateButtonCount());
		Assert.assertEquals(4,home.validateButtonCount());
		  
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		return TestUtil.getData("CareLoginTest");
		
	}
	
	
	@Test(priority=2, dataProvider="getData")
	public void signUpEmailandSelectACareGiver(String headerText){
		home.signUpWithEmail().hireACareGiver();
		String actual_text= tc.getCareTypeHeader();
		Assert.assertTrue(actual_text.contains(headerText));
		System.out.println("succesfully executed"+actual_text);
		
		
	}
	@AfterTest
	public void close(){
		
	}

}
