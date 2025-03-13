package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {
    public Login_PO(){
        super();
    }


    private @FindBy(id = "text")
    WebElement username_TextField;

    private  @FindBy(id = "password")
    WebElement password_textfield;

    private  @FindBy(id = "login-button")
    WebElement clickonLogin;



    public void navigateToWebDriverUniverseity_Login_page(){

        navigateTo_URL("http://webdriveruniversity.com/Login-Portal/index.html");

    }

    public void setUsername(String username){
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password){
        sendKeys(password_textfield, password);
    }

    public void clickOnLoginButton(){
        waitForWebElementAndclick(clickonLogin);
    }

    public void validate_SuccessfulLogin_message(){
        waitForAlert_And_ValidateText("validation succeeded");
    }

    public void validate_FailedLogin_message(){
        waitForAlert_And_ValidateText("validation failed");
    }




}
