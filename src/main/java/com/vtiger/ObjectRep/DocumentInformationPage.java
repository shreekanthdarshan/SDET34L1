package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class used for DocumentInformationPage
 * @author CHANDAN KUMARa
 *
 */
public class DocumentInformationPage {
  @FindBy(xpath = "//span[@id='dtlview_Title']")
  private WebElement createdDocumentTitle;
  
  public DocumentInformationPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  public String DocumentInformationPageAction() {
	 return createdDocumentTitle.getText();
  }
  
  
  
}
