package driver;

import io.cucumber.java.After;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {

    private static  ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    public  static  WebDriver getDriver(){
        if(webdriver.get() == null){
            webdriver.set(createDriver());
        }
        return webdriver.get();
    }

    private  static WebDriver createDriver(){

        WebDriver driver = null;
        String broswerType = getBrowerType();

        switch (broswerType){
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" ->{
                System.setProperty("webdriver.firefox.driver", "C:\\geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            }


        }
        driver.manage().window().maximize();
        return driver;
    }

   private  static  String getBrowerType()  {

        String browserType= null;

        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");

            properties.load(fis);
            browserType = properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
       return browserType;

    }

    public static  void cleanUpDriver() {
        webdriver.get().quit();
        webdriver.remove();
    }
}
