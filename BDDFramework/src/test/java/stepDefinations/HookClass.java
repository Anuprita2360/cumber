package stepDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import POMPages.LoginPage;
import POMPages.LogoutPage;
import genericUsability.PropertyFileUsability;
import genericUsability.SeleniumUsability;
import injector.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class HookClass {

	public  SeleniumUsability seleniumusability;
	public  LoginPage loginPage;
	public  LogoutPage logoutPage;

	BaseClass base;
	public HookClass(BaseClass base)
	{
		this.base=base;
	}


	@Before//acts as beforeMethod
	public void setUp()
	{
		PropertyFileUsability.initialisePropertyFile(".\\commonData.properties");
		seleniumusability=new SeleniumUsability();
		String browser = PropertyFileUsability.getDataFronProperty("browser");
		String url = PropertyFileUsability.getDataFronProperty("url");
		seleniumusability.setDriver(browser);
		seleniumusability.maximiseBrowser();
		seleniumusability.openApplication(url);



		String username = PropertyFileUsability.getDataFronProperty("username");System.out.println(username);
		String password = PropertyFileUsability.getDataFronProperty("password");System.out.println(password);

loginPage=new  LoginPage(base.driver);
loginPage.loginAction(username, password);

		

	}

	//	@BeforeAll  //acts as beforeSuite
	//	public static void beforeAll()
	//	{
	//			
	//	}
	//	
	//	@BeforeStep //
	//	public void beforeStep()
	//	{
	//		
	//	}
	//	
	//	@AfterStep
	//	public void afterStep()
	//	{
	//		
	//	}

	@After
	public void tearDown(Scenario scenario)
	{
		TakesScreenshot takescreenshot=(TakesScreenshot)base.driver;
		byte[] screen = takescreenshot.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screen, "img/png", scenario.getName());
		
		logoutPage=new LogoutPage(base.driver);
		logoutPage.clickSignOut(seleniumusability);
		seleniumusability.closeBrowser();
	}

	//	@AfterAll
	//	public static void afterAll()
	//	{
	//		
	//	}
	//	


}
