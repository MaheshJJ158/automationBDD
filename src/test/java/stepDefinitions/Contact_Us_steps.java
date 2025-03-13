package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;

import static driver.DriverFactory.getDriver;


public class Contact_Us_steps  extends Base_PO {


    private Contact_Us_PO contact_Us_Po;

    public Contact_Us_steps(Contact_Us_PO contact_Us_Po){
        this.contact_Us_Po = contact_Us_Po;

    }

    @Given("I access the WebDriver university Contact Us Page")
    public void i_access_the_web_driver_university_contact_us_page() {
       contact_Us_Po.navigate_TO_WebDriverUnivercity_page();
    }

    @When("I enter a unique fist name")
    public void i_enter_a_unique_fist_name() {
        contact_Us_Po.set_Firstname();}

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
    contact_Us_Po.set_Lastname();
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contact_Us_Po.set_Email();
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contact_Us_Po.set_Comment();
    }

    @Then("I click on submit button")
    public void i_click_on_submit_button() {
      contact_Us_Po.submitthe_form();
    }


    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionMessage() {
       contact_Us_Po.SuccessfulContactUsSubmissionMessage();
    }



    @When("I enter a specific fist name {word}")
    public void i_enter_a_specific_fist_name(String firstName) {
        contact_Us_Po.set_SpecificFirstname(firstName);
    }
    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contact_Us_Po.set_SpecficLastname(lastName);
    }
    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        contact_Us_Po.set_SpecficEmail(email);
       }
    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String conn) {
        contact_Us_Po.set_SpecficComment(conn);

     }


}
