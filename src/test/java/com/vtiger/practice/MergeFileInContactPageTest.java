package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET34L1.genricutility.IconstantPath;
import com.SDET34L1.genricutility.JavaUtility;
import com.SDET34L1.genricutility.MsExcelUtility;
import com.SDET34L1.genricutility.PropertyFileUtility;
import com.SDET34L1.genricutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeFileInContactPageTest {
	public static void main(String[]args) throws IOException, InterruptedException {
		WebDriver driver=null;

		JavaUtility jutil = new JavaUtility();
		MsExcelUtility msExcelUtility = new MsExcelUtility();
		PropertyFileUtility propertyFileUtility = new PropertyFileUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();

		try {
			msExcelUtility.openExcel(IconstantPath.CONTACTEXCELPATH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("excel not open");
		}
		try {
			propertyFileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("property file not open");
		}
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		webDriverUtility.browserSetting(driver, 10);
		//navigate to application
		webDriverUtility.navigateApp(propertyFileUtility.getDataFromPropertFile("url"), driver);
		String actual= "vtiger CRM 5 - Commercial Open Source CRM";
		jutil.assertionThroughIfCondition(actual, driver.getTitle(),msExcelUtility.getDataFromExcel("contactmodule", 3, 4));
		msExcelUtility.setDataintoExcel("contactmodule", 12, 5,"login page be displayed");
		//enter user name and password click on login button
		driver.findElement(By.name("user_name")).sendKeys(propertyFileUtility.getDataFromPropertFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(propertyFileUtility.getDataFromPropertFile("pasword"));
		driver.findElement(By.id("submitButton")).click();
		actual =driver.getTitle();
		jutil.assertionThroughIfCondition(actual, driver.getTitle(),msExcelUtility.getDataFromExcel("contactmodule", 3, 4));
		msExcelUtility.setDataintoExcel("contactmodule", 13, 5,"Home page be displayed"); 
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		actual=driver.getTitle();
		jutil.assertionThroughIfCondition(actual, driver.getTitle(), msExcelUtility.getDataFromExcel("contactmodule", 10, 2));
		msExcelUtility.setDataintoExcel("contactmodule", 14, 5,"create page displayed");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(propertyFileUtility.getDataFromPropertFile("contact"));
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		actual=driver.findElement(By.id("dtlview_Last Name")).getText();
		jutil.assertionThroughIfCondition(propertyFileUtility.getDataFromPropertFile("contact"), actual,propertyFileUtility.getDataFromPropertFile("contact"));
		msExcelUtility.setDataintoExcel("contactmodule", 14, 5,"contact created");

		driver.findElement(By.xpath("//td[.='More Information']")).click();
		driver.findElement(By.xpath("//img[@id='show_Contacts_Documents']")).click();
		driver.findElement(By.xpath("//input[@value='Add Document']")).click();
		driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(propertyFileUtility.getDataFromPropertFile("title"));
		driver.findElement(By.id("filename_I__")).sendKeys(IconstantPath.FILEUPLOAD);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		actual=driver.getTitle();
		jutil.assertionThroughIfCondition(actual, driver.getTitle(), actual);
		msExcelUtility.setDataintoExcel("contactmodule", 15, 5,"document got merged");


		WebElement signOut= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webDriverUtility.initalizeTheAction(driver);
		webDriverUtility.mouseHoverOntheElement(signOut );

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		actual=driver.getTitle();
		jutil.assertionThroughIfCondition(driver.getTitle(), actual, actual);
		msExcelUtility.setDataintoExcel("contactmodule", 16, 5,"logOut ucessfully");



		msExcelUtility.saveExcel(IconstantPath.CONTACTEXCELPATH);
		msExcelUtility.closeExcel();	
		webDriverUtility.quitBrowser(driver);
	}



}
