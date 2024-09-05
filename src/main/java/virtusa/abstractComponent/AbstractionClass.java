package virtusa.abstractComponent;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AbstractionClass {

	WebDriver driver;
	WebDriverWait wait;

	public AbstractionClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void presenceOfElementLocated(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void visibilityOfElementLocated(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void visibilityOfElementLocated(AppiumBy appiumBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(appiumBy));
	}

	public void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void elementToBeClickable(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void elementToBeClickable(AppiumBy appiumby) {
		wait.until(ExpectedConditions.elementToBeClickable(appiumby));
	}

	public void presenceOfElementLocated(AppiumBy appiumBy) {
		wait.until(ExpectedConditions.presenceOfElementLocated(appiumBy));
	}
	

	public void attributeContains(WebElement element, String attribute, String value) {
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}

	public void longPressGesture(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));

	}

	public void scrollingGesture(Object text) {

		driver.findElement(new AppiumBy.ByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
	}

	public void scrollingtoEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));
		} while (canScrollMore);
	}

	public void scrollingtoUpAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "up", "percent", 1.0));
		} while (canScrollMore);
	}

	public void swipingGesture(WebElement ele, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.25));
	}

	public void startAppActivity(String appActivity) {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", appActivity));
	}

}
