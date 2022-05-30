package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM Class used for ContactPage
 * @author CHANDAN KUMARa
 *
 */
public class ContactPage {
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createNewContactBtn;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void contactPageAction(){
		createNewContactBtn.click();
		
	}

}
