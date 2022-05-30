package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genricutility.WebDriverUtility;
/**
 * This POM Class used for CreateNewOrganizationPage
 * @author CHANDAN KUMARa
 *
 */

public class CreateNewOrganizationPage {
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationTxt;
	
	@FindBy(xpath = "//input[@accesskey='S']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement accounttypeDropDown;
	
	@FindBy(xpath = "//td[@class='dvtCellInfo']")
	private WebElement savedDropDown;
	
	
	/*@FindBy(how =How.ID_OR_NAME,id="Education")
	private WebElement industryDropDownByValue;*/
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
    public void enterTheOrganizationName(String organizationName ) {
    	organizationTxt.sendKeys(organizationName);
    }
    
    public void saveTheOrganization() {
    	saveBtn.click();
    }
    
    public void industryDropDown(String value) {
    	webDriverUtility.intializeTheSelect(industryDropDown);
    	webDriverUtility.selectByValue(value);
    }
    public void waitUntilIndustryDropDownSelect(WebDriver driver) {
    	webDriverUtility.explicitlyWait(driver, 10);
    	webDriverUtility.waitUntilElementVisible(savedDropDown);
    	
    }
	
    public void accounttypeDropDown(String value) {
    	webDriverUtility.intializeTheSelect(accounttypeDropDown);
    	webDriverUtility.selectByValue(value);
    }
}
