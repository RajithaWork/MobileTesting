package Virtusa.MobileFramework;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.virtusa.mobileTesting.android.pageObjectModel.CartPage;
import org.virtusa.mobileTesting.android.pageObjectModel.FormPage;
import org.virtusa.mobileTesting.android.pageObjectModel.ProductPage;

import com.aventstack.extentreports.ExtentReports;

import rajitha.TestComponents.BaseTest;
	
	
	
public class TC_004_CartClass extends BaseTest {
	
	ProductPage productpage;
	ExtentReports extent;
	@Test(dataProvider="getData",groups="Regression")
	public void cartpagevalidation(HashMap<Object,Object> input) throws InterruptedException {
		extent.createTest("CartClass");
		FormPage formpage = new FormPage(driver);
	    formpage.setName(input.get("name").toString());
	    formpage.setGender(input.get("gender").toString());
	    productpage = formpage.clickOnContinue();
	    
	    // Wait for product page to load
	    //"Nike SFB Jungle"
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/productName")));

	    @SuppressWarnings("unchecked")
        List<String> products = (List<String>) input.get("products");

        for (String product : products) {
            productpage.selectProductsAndClickOnAddToCart(product);
        }

	    CartPage cartpage= productpage.clickOnCartButton();
	    Thread.sleep(3000);
	    cartpage.titleName();
	    Thread.sleep(3000);
	    @SuppressWarnings("unchecked")
        List<String> cartproducts = (List<String>) input.get("products");

        for (String product : cartproducts) {
        	cartpage.verifyProductInCart(product);
        }
	    Thread.sleep(3000);
	    cartpage.verifyTotalPrice();
	    Thread.sleep(3000);
	    cartpage.acceptTermsAndConditions();
	    Thread.sleep(3000);
	    cartpage.proceedToWebsite();
	    Thread.sleep(3000);
	    extent.flush();
	}


}
