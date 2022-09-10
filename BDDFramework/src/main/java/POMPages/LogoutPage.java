package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUsability.SeleniumUsability;

public class LogoutPage {
	
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	public void clickSignOut(SeleniumUsability seleniumusability)
	{
		seleniumusability.mouseHoverOnElement(administratorIcon);
		signOutLink.click();
	}
}
