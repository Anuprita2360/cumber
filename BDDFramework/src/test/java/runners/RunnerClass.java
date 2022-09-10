package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {".\\src\\test\\java\\features"},
		glue = {"stepDefinations"},
		dryRun = false,
		monochrome = true,
        plugin = {
        		"pretty",
        		"html:ReadyCucumber.html",
        		"json:ReadyCucumber.json",
        }
        
        //tags = "@smokeTest"
		
		
		)
public class RunnerClass extends AbstractTestNGCucumberTests
{
	
}


