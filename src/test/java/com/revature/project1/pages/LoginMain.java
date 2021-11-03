package com.revature.project1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginMain {

    public WebDriver driver;

    @FindBy(id = "trms_page")
    public WebElement Login;

    public LoginMain(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


}