package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM  Class used for ContactInformationPage
 * @author CHANDAN KUMARa
 *
 */
public class ContactInformationPage {
	@FindBy(xpath = "//td[@id='mouseArea_Last Name']")
	private WebElement createdContactLastName;
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String ContactInformationPageAction() {
		 return createdContactLastName.getText();	
	}

}
