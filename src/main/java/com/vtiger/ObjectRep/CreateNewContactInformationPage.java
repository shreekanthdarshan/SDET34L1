package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genricutility.WebDriverUtility;

/**
 * This POM Class used for CreateNewContactInformationPage
 * @author CHANDAN KUMARa
 *
 */
public class CreateNewContactInformationPage {
	public WebDriverUtility webDriverUtility;
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactLastName;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement contactSaveBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement organizationSelectBtn;
	
	@FindBy(id = "search_txt")
	private WebElement organizationSearchTxt;
	
	@FindBy(xpath = "//input[@class='crmbutton small create']")
	private WebElement organizationSearchBtn;
	
	@FindBy(xpath = "//a[@id='1']")
	private WebElement selectOrganizationLnk;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	/*@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	private WebElement createdContactName;*/

	public CreateNewContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	public void contactInformationPageAction(String lastName) {
		contactLastName.sendKeys(lastName);
		
		

	}


	public void switchchild(WebDriver driver,String childBrowser,long longtime ) {
		webDriverUtility = new WebDriverUtility ();
		webDriverUtility.switchToChild(driver, childBrowser);
		webDriverUtility.explicitlyWait(driver, longtime);
		

	}
	
	public void addOrganizationTocontact() {
		organizationSelectBtn.click();
	}


	public void enterOrganizationNameEnter(String organizationName) {
		webDriverUtility.waitUntilElementVisible(organizationSearchTxt);
		organizationSearchTxt.sendKeys(organizationName);
		organizationSearchBtn.click();
		selectOrganizationLnk.click();
	}
	
	public void switchToParent(WebDriver driver,String parentBrowser) {
		webDriverUtility.switchToChild(driver,parentBrowser);
	}
	
	public void contactSave() {
		contactSaveBtn.click();
	}
	 
	/*public String createdContactName() {
	 return createdContactName.getText();
	 
	}*/
}
