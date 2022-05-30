package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genricutility.JavaUtility;
import com.SDET34L1.genricutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;
import com.vtiger.ObjectRep.CreateNewOrganizationPage;
import com.vtiger.ObjectRep.HomePage;
import com.vtiger.ObjectRep.LoginPage;
import com.vtiger.ObjectRep.OrganizationInformationPage;
import com.vtiger.ObjectRep.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {
	public  void createOrganizationTest() throws SQLException {
		String username=null;
		String password=null;
		String organizationaName=null;
		Connection connection=null;
		String url=null;
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();

		try{
			Driver d = new Driver();

			DriverManager.registerDriver(d);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger","root","root");
			Statement statement = connection.createStatement();
			ResultSet result= statement.executeQuery("select * from vtiger_data");

			while(result.next())
			{
				username = result.getString("user_name");
				url = result.getString("url");
				password = result.getString("password");
				int random = jutil.getRandomNumber(1000);
				organizationaName = result.getString("organization_name")+random;
			}
		}

		finally {
			connection.close();
		}


		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		webDriverUtility.browserSetting(driver, 10);
		webDriverUtility.initalizeTheAction(driver);
		webDriverUtility.navigateApp(url, driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
        OrganizationPage op = new OrganizationPage(driver);
       CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
       OrganizationInformationPage oIP = new OrganizationInformationPage(driver);
       
		lp.loginAction(username, password);
		
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();*/
		hp.homePageOrganizationAction();
		//driver.findElement(By.xpath("//a[.='Organizations']")).click();
		op.createNewOrganization();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		cnop.enterTheOrganizationName(organizationaName);
		//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationaName);
		cnop.saveTheOrganization();
		//driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		//WebElement ele= driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']"));
		String text= oIP.getcreatedOrgnizationName();
		System.out.println(text);
		jutil.assertionThroughIfCondition(text, organizationaName, organizationaName);
		hp.signOutIconMouseHoverAction(driver);
		/*WebElement signOut= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility.mouseHoverOntheElement(signOut);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		webDriverUtility.quitBrowser(driver);
	}


}
