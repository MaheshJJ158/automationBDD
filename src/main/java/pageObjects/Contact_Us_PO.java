package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Contact_Us_PO  extends  Base_PO{

    public Contact_Us_PO(){
        super();
    }


    private @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstname_field;


    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastname_field;
    private @FindBy(xpath = "//input[@name='email']")
    WebElement email_field;
    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement comment_field;
    private @FindBy(xpath = "//input[@class='contact_button'][2]")
    WebElement submitbutton;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement mymessage;

    public void navigate_TO_WebDriverUnivercity_page(){
        navigateTo_URL(" http://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void set_Firstname(){
        sendKeys(firstname_field, "Mahesh");
    }
    public void set_SpecificFirstname(String FN){
        sendKeys(firstname_field, FN);
    }

    public void set_Lastname(){
        sendKeys(lastname_field, "Jadhav");
    }
    public void set_SpecficLastname(String LN){
        sendKeys(lastname_field, LN);
    }

    public void set_Email(){
        sendKeys(email_field, "mahesh@gmail.com");
    }
    public void set_SpecficEmail(String EM){
        sendKeys(email_field, EM);
    }

    public void set_Comment(){
        sendKeys(comment_field, "how are you");
    }

    public void set_SpecficComment(String comm){
        sendKeys(comment_field, comm);
    }


    public void submitthe_form(){
        waitForWebElementAndclick(submitbutton);
    }

    public void SuccessfulContactUsSubmissionMessage(){
        String actual= mymessage.getText();
        //String expected = "Thank You for your Message!";
        Assert.assertEquals(actual, "Thank You for your Message!");
    }

}
