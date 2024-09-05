package org.virtusa.mobileTesting.android.pageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import virtusa.abstractComponent.AbstractionClass;

public class WebViewPage extends AbstractionClass{
	WebDriver driver;

	public WebViewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@name='q']")
	WebElement enterSomething;
	
	public void GoToWebsite(String website) {
		enterSomething.sendKeys(website);
		enterSomething.sendKeys(Keys.ENTER);
	}

}
