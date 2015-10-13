package com.example.nopom;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by andreicontan on 13/10/15.
 */
public class NoPomLoginTest {

@Test
    public void test_Home_Page(){

    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://mydemopage.com");
    driver.findElement(By.name("name")).sendKeys("demo");
    driver.findElement(By.name("name")).sendKeys("demo");
    driver.findElement(By.name("name")).sendKeys("demo");
    String hometext = driver.findElement(By.xpath("//table")).getText();

    assertTrue(hometext.toLowerCase().contains("bank"));
}
}
