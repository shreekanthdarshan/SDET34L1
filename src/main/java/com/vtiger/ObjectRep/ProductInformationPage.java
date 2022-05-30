package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM Class used for ProductInformationPage
 * @author CHANDAN KUMARa
 *
 */
public class ProductInformationPage {
    @FindBy(xpath = "//span[@id='dtlview_Product Name']")
    private WebElement createdProductName;
    
    public ProductInformationPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
     public String createdProductName() {
    	return createdProductName.getText();
     }
    
}
