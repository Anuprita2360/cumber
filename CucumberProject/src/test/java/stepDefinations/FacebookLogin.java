package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {
	WebDriver driver;
	@Given("Launch the browser")
	public void launch_the_browser() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("Enter the URL of Facebook")
	public void enter_the_url_of_Facebook() {
	   driver.get("https://www.facebook.com/");
	}

	@When("enter valid username and password")
	public void enter_valid_username_and_password() {

	driver.findElement(By.name("email")).sendKeys("rautanuprita96@gmail.com");
	driver.findElement(By.name("pass")).sendKeys("Anu@2360");
	}

	@When("enter valid username {string} and password {string}")
	public void enter_valid_username_and_password(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
	   driver.findElement(By.name("login")).click();
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}

	@Then("Verify the Homepage is displayed or not")
	public void verify_the_homepage_is_displayed_or_not() {
	String actualTitle = driver.getCurrentUrl();
	System.out.println(actualTitle);
	Assert.assertTrue(actualTitle.contains( "https://www.facebook.com/"));
    driver.quit();
	}


}
