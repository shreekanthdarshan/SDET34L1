package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM used Class used for CampaignPage
 * @author CHANDAN KUMARa
 *
 */
public class CampaignPage {
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createNewCampign;
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement campaignsaveBtn;
	
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void campaignPageAction() {
		createNewCampign.click();
	}
	public void campaignsave() {
		campaignsaveBtn.click();
	}

}
