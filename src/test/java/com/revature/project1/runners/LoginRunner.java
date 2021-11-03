package com.revature.project1.runners;


import com.revature.project1.pages.LoginMain;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"com.revature.project1.steps"})

public class LoginRunner {

    public static WebDriver driver;
    public static LoginMain loginMain;


    @BeforeClass
    public static void setUp() {
        String path = "C:/Users/Tutan/Documents/Revature/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();
        loginMain = new LoginMain(driver);
    }

//    @AfterClass
//    public static void tearDown() {
//        driver.quit();
//    }


}

