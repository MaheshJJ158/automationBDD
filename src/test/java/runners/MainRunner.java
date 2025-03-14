package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"classpath:features"},glue={"stepDefinitions"},
        tags = "@contact-us", monochrome = true,dryRun = false,
        plugin={"pretty","html:target/cucumber"}
)
public class MainRunner  extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
