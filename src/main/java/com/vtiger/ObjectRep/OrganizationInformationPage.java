package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM Class used for OrganizationInformationPage
 * @author CHANDAN KUMARa
 *
 */
public class OrganizationInformationPage {
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement createdOrgnizationName;
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getcreatedOrgnizationName() {
		return createdOrgnizationName.getText();
	}
}
