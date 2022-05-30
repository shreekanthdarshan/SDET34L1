package com.vtiger.ObjectRep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genricutility.WebDriverUtility;
/**
 * This POM Class used for CreateNewCampignPage
 * @author CHANDAN KUMARa
 *
 */
public class CreateNewCampignPage {
	public WebDriverUtility webDriverUtility;


	@FindBy(name = "campaignname")
	private WebElement campaignnameTxt;
	@FindBy(xpath = "//img[@tabindex='']")
	private WebElement addProductBtn;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement productTxt;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement serachBtn;

	@FindBy(xpath = "//a[@id='1']")
	private WebElement selectProductLnk;

	public CreateNewCampignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void createCampaignPageAction(String campaignname) {
		campaignnameTxt.sendKeys(campaignname);
	}

	public void addproductBtn() {
		addProductBtn.click();
	}

	public void switchToChild(WebDriver driver, String title) {
		webDriverUtility = new WebDriverUtility ();
		webDriverUtility.switchToChild(driver, title);
	} 
	public void insideChildBrowserAction(String productName,WebDriver driver) {
		productTxt.sendKeys(productName);
		
		serachBtn.click();
		driver.findElement(By.linkText(productName)).click();
	}

	public void switchToParent(WebDriver driver, String title) {
		webDriverUtility.switchToChild(driver, title);
	}

}
