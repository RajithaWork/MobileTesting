package Virtusa.MobileFramework;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.virtusa.mobileTesting.android.pageObjectModel.FormPage;
import rajitha.TestComponents.BaseTest;

public class TC_002_ErrorValidations extends BaseTest{
	
	
	
	@Test(dataProvider="getData",groups="Negative")
	public void errorValidation(HashMap<String, String> input) {
		FormPage formpage=new FormPage(driver);
		
		formpage.setGender(input.get("gender"));
		formpage.clickOnContinue();
		formpage.validateErrorMessage("Please enter your name");
		
	}
	
	

}
