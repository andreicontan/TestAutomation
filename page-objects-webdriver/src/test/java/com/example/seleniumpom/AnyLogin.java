package com.example.seleniumpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by andreicontan on 13/10/15.
 */
public class AnyLogin {

    WebDriver driver;
    By userName = By.name("username");
    By passWord = By.name("password");
    By titleText = By.className("myClassName");
    By login = By.name("btnLogin");

    public AnyLogin(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }
}
