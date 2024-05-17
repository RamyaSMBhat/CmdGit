package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisplayCustomViewDetailsPage {
	@FindBy(id="Campaignstab")
	private WebElement campaignTab;
	
	@FindBy(id="Leadstab")
	private WebElement leadsTab;
	
	@FindBy(id="Potentialstab")
	private WebElement potentialsTab;
	
	public DisplayCustomViewDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setCampaignTab() {
		campaignTab.click();
	}

	public void setLeadsTab() {
		leadsTab.click();
	}

	public void setPotentialsTab() {
		potentialsTab.click();
	}
	
	

}
