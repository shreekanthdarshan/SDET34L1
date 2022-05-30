package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM Class used for OrganizationPage
 * @author CHANDAN KUMARa
 *
 */
public class OrganizationPage {
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrganizationtn;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void createNewOrganization() {
		createNewOrganizationtn.click();
	}

}
