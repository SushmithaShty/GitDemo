package cucumberoptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features", 
		glue="stepDefinations", 
		monochrome=true, 
		tags="@PlaceOrder or @OffersPage",
		plugin= {"html:targets/cucumber.html", "json:targets/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		})
public class JunitTestRunnerTest
{
	
}