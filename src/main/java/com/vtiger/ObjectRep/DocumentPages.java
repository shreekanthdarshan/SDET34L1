package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM Class used for DocumentPages
 * @author CHANDAN KUMARa
 *
 */
public class DocumentPages {
	 @FindBy(xpath = "//img[@title='Create Document...']")
	 private WebElement createNewDocumentBtn;
	 
	 public DocumentPages(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void createNewDocumentBtn() {
		 createNewDocumentBtn.click();
	 }

}
