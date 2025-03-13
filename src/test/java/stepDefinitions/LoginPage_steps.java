package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Background;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

import static driver.DriverFactory.getDriver;


public class LoginPage_steps extends Base_PO {

    private Login_PO login_Po;

    public LoginPage_steps(Login_PO login_Po){
        this.login_Po = login_Po;
    }

    @Given("I access the WebDriver university Login Page")
    public void i_access_the_web_driver_university_login_page() {
        login_Po.navigateToWebDriverUniverseity_Login_page();

    }

    @When("I enter a username {}")
    public void i_enter_a_unique_username(String username) {
        login_Po.setUsername(username);


    }
    @And("I enter Password {}")
    public void i_enter_password(String password) {
        login_Po.setPassword(password);

    }


    @And("I click on submit button to login")
    public void i_click_on_submit_button_to_login() {
        login_Po.clickOnLoginButton();

    }
    @Then("I validate the alert message")
    public void i_validate_the_alert_message() {
       login_Po.validate_SuccessfulLogin_message();

    }


    @Then("I validate the failed alert message")
    public void i_validate_the_failed_alert_message() {
        login_Po.validate_FailedLogin_message();

    }

    @Then("I should be presented with following login validation message {}")
    public void i_should_be_presented_with_following_login_validation_message(String expectedmsg) {
        waitForAlert_And_ValidateText(expectedmsg);

    }

}
