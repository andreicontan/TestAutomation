package com.example.seleniumpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by andreicontan on 13/10/15.
 */
public class HomePage {


    WebDriver driver;

    //By homePageUserName = By.xpath("//table//tr[@class='heading3']");

    @FindBy(xpath = "//yourXpath")
    WebElement homePageUserName;

    public HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    //Get the User name from Home Page

    public String getHomePageDashboardUserName(){

        //return    driver.findElement(homePageUserName).getText();
        return homePageUserName.getText();

    }
}
