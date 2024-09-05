package Virtusa.MobileFramework;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.virtusa.mobileTesting.android.pageObjectModel.CartPage;
import org.virtusa.mobileTesting.android.pageObjectModel.FormPage;
import org.virtusa.mobileTesting.android.pageObjectModel.ProductPage;
import org.virtusa.mobileTesting.android.pageObjectModel.WebViewPage;

import rajitha.TestComponents.BaseTest;

public class TC_005_WebView extends BaseTest{
	ProductPage productpage;
	
	@Test
	public void webViewPage() throws InterruptedException {
	
	FormPage formpage = new FormPage(driver);
    formpage.setName("Rajitha Banoth");
    formpage.setGender("male");
    productpage = formpage.clickOnContinue();
    
    // Wait for product page to load
    //"Nike SFB Jungle"
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/productName")));

    productpage.selectProductsAndClickOnAddToCart("Air Jordan 9 Retro","PG 3");
    CartPage cartpage= productpage.clickOnCartButton();
    Thread.sleep(3000);
    cartpage.titleName();
    Thread.sleep(3000);
    cartpage.verifyProductInCart("Air Jordan 9 Retro","PG 3");
    Thread.sleep(3000);
    cartpage.verifyTotalPrice();
    Thread.sleep(10000);
    cartpage.acceptTermsAndConditions();
    Thread.sleep(3000);
    WebViewPage webview=cartpage.proceedToWebsite();
    Thread.sleep(1000);
    driver.context("NATIVE_APP");
    webview.GoToWebsite("google.com");
    Thread.sleep(3000);
}
	
	
}
	
	
	
	
	

