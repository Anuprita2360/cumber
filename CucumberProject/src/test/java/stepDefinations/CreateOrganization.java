package stepDefinations;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {
	WebDriver driver;
@Given("Launch browser")
public void launch_browser() {
	 WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Given("Enter URL")
public void enter_url() {
	 driver.get("http://localhost:8888/");
}

@Given("In Login Page enter username and password and click on login button")
public void in_login_page_enter_username_and_password_and_click_on_login_button() {
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	 driver.findElement(By.id("submitButton")).click();
}

@When("Click on org link")
public void click_on_org_link() {
	driver.findElement(By.xpath("//table[@class='hdrTabBg']/tbody/tr/child::td[@class='small']/table/tbody/tr/td/following-sibling::td/a[text()='Organizations']")).click();
	

}

@When("Click on create org image")
public void click_on_create_org_image() {
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
}


@When("Enter org name {string} and select Industry click on save button")
public void enter_org_name_and_select_industry_click_on_save_button(String orgName) {
	int ranNum=new Random().nextInt(100);
	driver.findElement(By.name("accountname")).sendKeys(orgName+ranNum);
	WebElement IndustryDropDown = driver.findElement(By.xpath("//select[@name='industry']"));
	Select selectIndustry=new Select(IndustryDropDown);
	List<WebElement> options = selectIndustry.getOptions();
	int count=options.size();
	String text = null;
	for(int i=0;i<count;i++)
	{
		selectIndustry.selectByIndex(8);
		text = options.get(8).getText();
	
	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
}


@Then("Verify org is created or not")
public void verify_org_is_created_or_not1(String orgName) {
	String actualOrganisationName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	Assert.assertTrue(actualOrganisationName.contains(orgName));
	driver.quit();
}

@When("Enter org name {string} and {string} click on save button")
public void enter_org_name_and_click_on_save_button(String orgName, String email) {
	int ranNum=new Random().nextInt(100);
	driver.findElement(By.name("accountname")).sendKeys(orgName+ranNum);
	driver.findElement(By.id("email1")).sendKeys(email);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
}
@Then("Verify org {string} is created or not")
public void verify_org_is_created_or_not(String orgName) {
	String actualOrganisationName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	Assert.assertTrue(actualOrganisationName.contains(orgName));
	driver.quit();
}
@When("Enter org name orgName and email email select Industry click on save button")
public void enter_org_name_org_name_and_email_email_select_industry_click_on_save_button(io.cucumber.datatable.DataTable dataTable) {
	int ranNum=new Random().nextInt(100);
	List<List<String>> data=dataTable.asLists();
    String orgname=data.get(1).get(0);
    String email=data.get(1).get(1);
    driver.findElement(By.name("accountname")).sendKeys(orgname+ranNum);
	driver.findElement(By.id("email1")).sendKeys(email);
	WebElement IndustryDropDown = driver.findElement(By.xpath("//select[@name='industry']"));
	Select selectIndustry=new Select(IndustryDropDown);
	List<WebElement> options = selectIndustry.getOptions();
	int count=options.size();
	String text = null;
	for(int i=0;i<count;i++)
	{
		selectIndustry.selectByIndex(8);
		text = options.get(8).getText();
	
	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
}
@Then("Verify org orgName is created or not")
public void verify_org_org_name_is_created_or_not(io.cucumber.datatable.DataTable dataTable) {
	List<List<String>> data=dataTable.asLists();
    String orgname=data.get(1).get(0);
	String actualOrganisationName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	Assert.assertTrue(actualOrganisationName.contains(orgname));
	driver.quit();
}

}
