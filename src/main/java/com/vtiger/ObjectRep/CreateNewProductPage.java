package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM Class used for CreateNewProductPage
 * @author CHANDAN KUMARa
 *
 */
public class CreateNewProductPage {
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productNameTxt;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement productsaveBtn;
	
	public CreateNewProductPage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
		}
	
	public void createNewProductAction(String prodctName) {
		productNameTxt.sendKeys(prodctName);
	}
	
	public void saveProduct() {
		//productsaveBtn.click();
	}
}
