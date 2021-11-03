package com.revature.project1.steps;

import com.revature.project1.pages.LoginMain;
import com.revature.project1.runners.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TRMSLoginImpl {
    public static LoginMain loginMain = LoginRunner.loginMain;
    public static WebDriver driver = LoginRunner.driver;

    //Will have methods to be executed that correspond to the Scenario steps.
    @Given("The Guest is on the Employee Page")
    public void the_guest_is_on_the_Employee_page() {
        driver.get("file:///C:/Users/Tutan/Documents/Revature/TRMS_P1/FrontEnd/EMPLOYEE_PAGE.html");
    }

    @When("The Guest clicks Click Here")
    public void the_guest_clicks_Login() {
        loginMain.Login.click();
    }

    @Then("The Guest should be on the TRMS Page")
    public void the_guest_should_be_on_the_Employee_Page() {
        String expected = "TRMS Form";
        Assert.assertEquals(expected, driver.getTitle());
    }

}

