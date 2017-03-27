package testcases.care;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.testBase;
import screens.care.CreateAccountScreen;
import screens.care.TypeOfCareGiver;
import utility.TestUtil;
import utility.excelReader;

public class AddTutor extends testBase {
	TypeOfCareGiver tc;
	CreateAccountScreen create;
	@BeforeTest
	public void init(){
		
		tc= new TypeOfCareGiver(driver);
		create= new CreateAccountScreen(driver);
	}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		
		
		
		return TestUtil.getData("AddTutor");
		
	}
	
	@Test(dataProvider="getData")
	public void addTutor(String userName, String password, String firstName, String lastName, String dob){
		tc.selectTypeOfCare();
		create.addInformation(userName, password, firstName, lastName, dob);
	}

}
