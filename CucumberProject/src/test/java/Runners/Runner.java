package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\java\\features"},
		glue = {"stepDefinations","hook"},
		dryRun = true,
		monochrome = true,
        plugin = {
        		"pretty",
        		"html:ReadyCucumber.html",
        		"json:ReadyCucumber.json",
        },
        
        tags = "@smokeTest"
		
		)

public class Runner extends AbstractTestNGCucumberTests
{
	
}
