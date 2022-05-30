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

public class DeleteMailMergeTemplate {
	public static void main(String[]args) throws IOException {
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
		msExcelUtility.setDataintoExcel("contactmodule", 3, 5,"login page be displayed");
		//enter user name and password click on login button
		driver.findElement(By.name("user_name")).sendKeys(propertyFileUtility.getDataFromPropertFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(propertyFileUtility.getDataFromPropertFile("pasword"));
		driver.findElement(By.id("submitButton")).click();
		actual =driver.getTitle();
		jutil.assertionThroughIfCondition(actual, driver.getTitle(),msExcelUtility.getDataFromExcel("contactmodule", 3, 4));
		msExcelUtility.setDataintoExcel("contactmodule", 4, 5,"Home page be displayed"); 
		WebElement setting = driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']"));
		webDriverUtility.initalizeTheAction(driver);

		webDriverUtility.mouseHoverOntheElement(setting);

		driver.findElement(By.xpath("//a[.='CRM Settings']")).click();
		msExcelUtility.setDataintoExcel("contactmodule", 5, 5,"setting page displayed");
		driver.findElement(By.xpath("//img[@alt='Mail Merge']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		msExcelUtility.setDataintoExcel("contactmodule", 4, 5,"deleted be succesfully");
		WebElement signOut= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webDriverUtility.mouseHoverOntheElement(signOut );
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		msExcelUtility.saveExcel(IconstantPath.CONTACTEXCELPATH);
		msExcelUtility.closeExcel();	
		webDriverUtility.quitBrowser(driver);
	}


}
