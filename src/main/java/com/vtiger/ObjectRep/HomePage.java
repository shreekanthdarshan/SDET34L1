package com.vtiger.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genricutility.JavaUtility;
import com.SDET34L1.genricutility.WebDriverUtility;
/**
 *  This POM Class used for HomePage
 * @author CHANDAN KUMARa
 *
 */
public class HomePage {
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	@FindBy(xpath ="//a[.='Organizations']")
	private WebElement OrganizationsLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrationIcon;
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLnk;
	@FindBy(xpath = "//a[.='Documents']")
	private WebElement documentLink;
	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactLnk;
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productLnk;
	
	@FindBy(xpath = "//a[.='More']")
	private WebElement moreLnk;
	
	@FindBy(name = "Campaigns")
	private WebElement campaignsLnk;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void homePageOrganizationAction() {
		OrganizationsLink.click();
	}
	
	public void signOutIconMouseHoverAction(WebDriver driver) {
		webDriverUtility.initalizeTheAction(driver);
		webDriverUtility.mouseHoverOntheElement(adminstrationIcon);
		
		signOutLnk.click();
	}
	
	public void homePageDocumentLink() {
		documentLink.click();
	}
	public void HomePageContactLink() {
		contactLnk.click();
	}
	
	public void HomePageProductLink() {
		productLnk.click();
		
	}
	public void HompageMoreLink(WebDriver driver) {
		webDriverUtility.initalizeTheAction(driver);
		webDriverUtility.mouseHoverOntheElement(moreLnk);
	}
	public void HomepageCampaignsLink() {
		campaignsLnk.click();
	}

}
