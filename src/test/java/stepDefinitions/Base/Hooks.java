package stepDefinitions.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.Timestamp;

import static driver.DriverFactory.cleanUpDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {

    public WebDriver driver;

    @Before
    public  void setUp(){
     getDriver();
    }

    @AfterStep
    public void captureExpectionImage(Scenario scenario){
        if(scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMillieseconds = Long.toString(timestamp.getTime());

            byte[] screenshot =((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMillieseconds);

        }

    }

    @After
    public void tearDown( ){
        cleanUpDriver();
    }

}
