package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUsability.SeleniumUsability;



public class CampainsPage {
	public CampainsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreTab;
	@FindBy(name="Campaigns")
	private WebElement campaignsTab;

	
	//Business Library
	
	/**
	 * This method is used to click on the create campaign button
	 * @param expectedCampaignname
	 */
	public void clickMore(SeleniumUsability seleniumusability) 
	{
		seleniumusability.initialiseActions();
		seleniumusability.mouseHoverOnElement(moreTab);	
		moreTab.click();
	}
	
	public void clickCampaign()
	{
		campaignsTab.click();
	}
	
}
