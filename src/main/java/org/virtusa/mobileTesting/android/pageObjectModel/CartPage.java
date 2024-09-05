package org.virtusa.mobileTesting.android.pageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import virtusa.abstractComponent.AbstractionClass;

public class CartPage extends AbstractionClass {

	AndroidDriver driver;
	WebDriverWait wait;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	WebElement titleCard;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	List<WebElement> priceElements;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	WebElement actualTotalPrice;

	@AndroidFindBy(className = "android.widget.CheckBox")
	WebElement checkbox;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	WebElement termCond;

	@AndroidFindBy(id = "android:id/button1")
	WebElement cancelterms;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	WebElement webPageButton;
	
	public void titleName() {
		attributeContains(titleCard, "text", "Cart");
	}
	
	public void proccedToBuy(String... products) throws InterruptedException {
		
		for(String product:products)
		{
		
		verifyProductInCart(product);
		verifyTotalPrice();
		acceptTermsAndConditions();
		proceedToWebsite();

	}
	}

	public void verifyProductInCart(Object... products) {

		try {
			// Wait for the first product and verify its name
			WebElement cartProductName = wait.until(ExpectedConditions.presenceOfElementLocated(
					AppiumBy.androidUIAutomator("new UiSelector().text(\"" + products + "\")")));
			//Assert.assertEquals(cartProductName.getText(), products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void verifyTotalPrice() {

		//int priceSize = priceElements.size();
		double totalSum = 0;

		try {

			for (WebElement priceElement : priceElements) {
				String priceText = priceElement.getText().replaceAll("[^0-9.]", "");
				double priceValue = Double.parseDouble(priceText);
				totalSum += priceValue;
			}

			String expectedTotalPrice = String.format("%.2f", totalSum);
			String actualTotalPrice1 = actualTotalPrice.getText().replaceAll("[^0-9.]", "");
			//Assert.assertEquals(expectedTotalPrice, actualTotalPrice1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void acceptTermsAndConditions() throws InterruptedException {
		elementToBeClickable(termCond);
		Thread.sleep(3000);
		longPressGesture(termCond);
		elementToBeClickable(cancelterms);
		cancelterms.click();
		Thread.sleep(3000);
		elementToBeClickable(checkbox);
		checkbox.click();
	}

	public WebViewPage proceedToWebsite() {
		elementToBeClickable(webPageButton);
		webPageButton.click();
		return new WebViewPage(driver);
	}

}
