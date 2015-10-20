package com.example.nopom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by andreicontan on 20/10/15.
 */
public class SeleniumFirstClassWithTestNG {

    String baseUrl = "http://google.com";
    WebDriver driver = null;


    @BeforeMethod()
    public void lauchBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/chromedriver");
         driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test()
    public void testWebPageTitle() {

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

   @AfterClass
   public void closeBrowsers(){
       driver.close();
       driver.quit();
   }



}
