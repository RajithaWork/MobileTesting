package Virtusa.MobileFramework;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.virtusa.mobileTesting.android.pageObjectModel.FormPage;
import org.virtusa.mobileTesting.android.pageObjectModel.ProductPage;

import rajitha.TestComponents.BaseTest;

public class TC_003_ProductClass extends BaseTest {
    
    ProductPage productpage;
    
    @Test(dataProvider="getData",groups="Regression")
    public void loginSetUp(HashMap<Object, Object> input) throws InterruptedException {
        FormPage formpage = new FormPage(driver);

        
            formpage.setName(input.get("name").toString());
            Thread.sleep(3000);
            formpage.setGender(input.get("gender").toString());
            Thread.sleep(3000);
            productpage = formpage.clickOnContinue();
            Thread.sleep(3000);

            // Wait for product page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/productName")));
            Thread.sleep(3000);
            @SuppressWarnings("unchecked")
            List<String> products = (List<String>) input.get("products");

            for (String product : products) {
                productpage.selectProductsAndClickOnAddToCart(product);
            }

            Thread.sleep(3000);
            productpage.clickOnCartButton();
            Thread.sleep(3000);
        }
            
    }

