package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genricutility.JavaUtility;
import com.SDET34L1.genricutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;
import com.vtiger.ObjectRep.ContactInformationPage;
import com.vtiger.ObjectRep.ContactPage;
import com.vtiger.ObjectRep.CreateNewContactInformationPage;
import com.vtiger.ObjectRep.HomePage;
import com.vtiger.ObjectRep.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithValidDateformatTest {
	public static void main(String[]args) throws Throwable {
		Connection connection=null;
		Statement statement=null;
		String username=null,password=null,contact=null,url=null,browser=null;
		long longtime =10;
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		try{
			 
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from vtiger_data");
			while(result.next()) {
				username = result.getString("user_name");
				password = result.getString("password");
				contact = result.getString("last_name");
				url = result.getString("url");
				String timeout = result.getString("timeout");
				longtime=jutil.stringToLong(timeout);
				browser= result.getString("browsername");
			}

		}
		finally {
			connection.close();

		}		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();


		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		webDriverUtility.navigateApp(url, driver);
		webDriverUtility.browserSetting(driver, longtime);
		webDriverUtility.initalizeTheAction(driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		CreateNewContactInformationPage cncip= new CreateNewContactInformationPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);
		lp.loginAction(username, password);
		hp.HomePageContactLink();

		cp.contactPageAction();
		cncip.contactInformationPageAction(contact);
		String toadydatebysystem = jutil.getDateFormat();
		System.out.println(toadydatebysystem);
		cncip.contactSave();
       String todayDate = driver.findElement(By.xpath("//td[.='Created Time']/following-sibling::td[1]")).getText();
        System.out.println(todayDate);
		String contacts = cip.ContactInformationPageAction();
     jutil.assertionThroughIfCondition(toadydatebysystem, todayDate, contacts);

		System.out.println(contacts);
		jutil.assertionThroughIfCondition(contacts, contact, contact);

		hp.signOutIconMouseHoverAction(driver);

		webDriverUtility.quitBrowser(driver);
	}



}


