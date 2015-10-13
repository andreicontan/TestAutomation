package com.example.test;

import com.example.seleniumpom.HomePage;
import com.example.seleniumpom.LoginPage;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;


import java.util.concurrent.TimeUnit;

/**
 * Created by andreicontan on 13/10/15.
 */
public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.login.com");

    }

    @Test
    public void test_HomePage_containsTitle(){

        loginPage = new LoginPage(driver);

        String loginPageTitle = loginPage.getLoginTitle();

        Assert.assertTrue(loginPageTitle.toLowerCase().contains("Page Title"));
    }

    @Test
    public void test_LoginPage_validCredentials(){
        String USERNAME = "user123";
        String PASSWORD = "pwd123";
        loginPage = new LoginPage(driver);
        loginPage.loginUser(USERNAME, PASSWORD);
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getHomePageDashboardUserName().toLowerCase().contains(PASSWORD));
    }

    @AfterTest
    public void cleanUp(){
        driver.close();
        driver.quit();
    }

}
