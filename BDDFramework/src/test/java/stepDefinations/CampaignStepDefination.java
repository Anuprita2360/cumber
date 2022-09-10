package stepDefinations;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import POMPages.CampaignInfoPage;
import POMPages.CampainsPage;
import POMPages.CreateCampaignPage;
import genericUsability.SeleniumUsability;
import injector.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CampaignStepDefination {
	
	 public  SeleniumUsability seleniumusability;
	 CreateCampaignPage createCampaignPage;
	 String actCampaignName;
	 String expectedCampaignname;
	 BaseClass base;
	 public CampaignStepDefination(BaseClass base)
	 {
		 this.base=base;
	 }
	@When("Click on Campaigns link")
	public void click_on_campaigns_link() {
		seleniumusability=new SeleniumUsability();
		CampainsPage campaignsPage=new CampainsPage(base.driver);
		campaignsPage.clickMore(seleniumusability);
		campaignsPage.clickCampaign();
		
	}
	@When("Click on create Campaigns image")
	public void click_on_create_campaigns_image() {
		createCampaignPage = new CreateCampaignPage(base.driver);
		createCampaignPage.clickOnCreateCampaignBtn();
	
	}
	@When("Enter Campaign name {string} click on save button")
	public void enter_campaign_name_click_on_save_button(String expectedCampaignname, io.cucumber.datatable.DataTable dataTable) {
		int ranNum=new Random().nextInt(100);
		expectedCampaignname=createCampaignPage.createCampaign(expectedCampaignname+ranNum);
	}
	@Then("Verify Campaign {string} is created or not")
	public void verify_campaign_is_created_or_not(String ExpectedCampaignname, io.cucumber.datatable.DataTable dataTable) {
		CampaignInfoPage campaignInfoPage = new CampaignInfoPage(base.driver);
		List<List<String>> data=dataTable.asLists();
	    String expectedCampaignname=data.get(1).get(0);
		
		Assert.assertTrue(campaignInfoPage.getActualCampaignName().contains(expectedCampaignname));
	}


}
