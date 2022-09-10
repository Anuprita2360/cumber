package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignBtn;
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignNammeTextField;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//Business library
	
	/**
	 * This method is used to click on the create Campaign button
	 */
	public void clickOnCreateCampaignBtn()
	{
		createCampaignBtn.click();
	}
	public String createCampaign(String expectedCampaignname)
	{
		campaignNammeTextField.sendKeys(expectedCampaignname);
		saveBtn.click();
		return expectedCampaignname;
	}


}
