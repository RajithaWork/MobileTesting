package org.virtusa.mobileTesting.android.pageObjectModel;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import virtusa.abstractComponent.AbstractionClass;

public class ProductPage extends AbstractionClass {

    AndroidDriver driver;
    WebDriverWait wait;
    public ProductPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
       
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> productsName;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> addTocart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;

   
    public void selectProductsAndClickOnAddToCart(Object... products) throws InterruptedException {
       
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/productName")));
        for (Object product : products) {
        	
                try {
                	Thread.sleep(3000);
                    scrollingGesture(product);
                    Thread.sleep(3000);
                    selectProduct(product);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("Exception occurred while selecting product: " + product);
                    e.printStackTrace();
                }
            }
        }
    

    public void selectProduct(Object product) {
    
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/productName")));
        for (int i = 0; i < productsName.size(); i++) {
        	String productName = productsName.get(i).getText();
            

            if (productName.equals(product)) {
                try {
                	elementToBeClickable(addTocart.get(i));
                	addTocart.get(i).click();
                } catch (Exception e) {
                    System.out.println("Exception occurred while clicking Add to Cart for product: " + product);
                    e.printStackTrace();
                }
                break; // Exit the loop once the product is found and clicked
            }
        }
    }

    public CartPage clickOnCartButton() {
        try {
        	elementToBeClickable(cartButton);
        	cartButton.click();
        	
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking on the cart button.");
            e.printStackTrace();
        }
        return new CartPage(driver);
    }

  
	
}
