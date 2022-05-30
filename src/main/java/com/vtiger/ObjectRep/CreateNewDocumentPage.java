package com.vtiger.ObjectRep;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genricutility.JavaUtility;
import com.SDET34L1.genricutility.WebDriverUtility;
/**
 * This POM Class used for CreateNewDocumentPage
 * @author CHANDAN KUMARa
 *
 */
public class CreateNewDocumentPage {
	JavaUtility jutil = new JavaUtility();
	 WebDriverUtility webDriverUtility = new WebDriverUtility ();
	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement documentTitleTxt;
	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement documentDescriptionTxtArea;
	@FindBy(xpath = "//a[@title='Bold']")
	private WebElement documentDescriptionBold;
	@FindBy(xpath = "//a[@title='Italic']")
	private WebElement documentDescriptionItalic;
	@FindBy(id = "filename_I__")
	private WebElement documentUploadFile;
	@FindBy(xpath  = "//b[.='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")
	private WebElement documentSaveBtn;
	
	
	public CreateNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void documentPageActions(WebDriver driver,int index,String title,String description,String filePath)  {
		documentTitleTxt.sendKeys(title);
		webDriverUtility.switchToFrame(driver,index);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in document action");
		}
		documentDescriptionTxtArea.sendKeys(description);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		documentDescriptionTxtArea.sendKeys(Keys.CONTROL+"a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		documentDescriptionBold.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jutil.customWait(documentDescriptionItalic, 10, 10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		documentDescriptionItalic.click();
		documentUploadFile.sendKeys(filePath);
		 documentSaveBtn.click();
	}
	

}
