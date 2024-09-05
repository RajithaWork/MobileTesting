package Virtusa.MobileFramework;

import java.util.HashMap;
import org.testng.annotations.Test;
import org.virtusa.mobileTesting.android.pageObjectModel.FormPage;
import rajitha.TestComponents.BaseTest;

public class TC_001_FormClass extends BaseTest {

	@Test(dataProvider = "getData",groups="Negative")
	public void formpagevalidation(HashMap<String, String> input) throws InterruptedException {
		FormPage formpage = new FormPage(driver);
		formpage.selectCountryDropDown(input.get("country"));
		formpage.setName(input.get("name"));
		formpage.setGender(input.get("gender"));
		formpage.clickOnContinue();
		
	}

}
