package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM used Class used for campaignInformationPage
 * @author CHANDAN KUMARa
 *
 */
public class CampaignInforamationPage {
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement createdCampaignNameText;
	
	public CampaignInforamationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 public String createdCampaignNameText() {
		return createdCampaignNameText.getText();
	 }

}
