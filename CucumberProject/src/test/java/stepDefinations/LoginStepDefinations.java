package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import hook.HookClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinations {

WebDriver driver;
@Given("Launch a browser")
public void launch_a_browser() {
  WebDriverManager.chromedriver().setup();
  driver=new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Given("Enter the URL")
public void enter_the_url() {
   driver.get("http://localhost:8888/");
}

@When("Login page is displayed enter valid username and password")
public void login_page_is_displayed_enter_valid_username_and_password() {

driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
}

@When("Login page is displayed enter valid username {string} and password {string}")
public void login_page_is_displayed_enter_valid_username_and_password(String username, String password) {
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
}

@When("Click on login button")
public void click_on_login_button() {
   driver.findElement(By.id("submitButton")).click();
}

@Then("Verify Homepage is displayed or not")
public void verify_homepage_is_displayed_or_not() {
String actualTitle = driver.getTitle().trim();
Assert.assertTrue(actualTitle.contains( "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"));
driver.quit();
}

@Then("Verify error msg is displayed or not")
public void verify_error_msg_is_displayed_or_not() {
   Assert.assertTrue(driver.findElement(By.xpath("//div[@class='errorMessage']")).isDisplayed());
   driver.quit();
}


}
