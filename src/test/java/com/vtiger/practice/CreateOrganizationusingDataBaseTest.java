package com.vtiger.practice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genricutility.DatabaseLibrary;
import com.SDET34L1.genricutility.IconstantPath;
import com.SDET34L1.genricutility.JavaUtility;
import com.SDET34L1.genricutility.PropertyFileUtility;
import com.SDET34L1.genricutility.WebDriverUtility;
import com.vtiger.ObjectRep.CreateNewOrganizationPage;
import com.vtiger.ObjectRep.HomePage;
import com.vtiger.ObjectRep.LoginPage;
import com.vtiger.ObjectRep.OrganizationInformationPage;
import com.vtiger.ObjectRep.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationusingDataBaseTest {
	public static void main (String[]args) throws SQLException, IOException {
		String username=null;
		String password=null;
		String organizationaName=null;
		String url=null;
		JavaUtility jutil = new	JavaUtility();
		PropertyFileUtility propertyFileUtility = new PropertyFileUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		propertyFileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);

		DatabaseLibrary.openDbConnection(IconstantPath.MSQLPATH+propertyFileUtility.getDataFromPropertFile("dbDatabase"),propertyFileUtility.getDataFromPropertFile("dbusername"), propertyFileUtility.getDataFromPropertFile("dbpassword"));
		ArrayList<String> data = DatabaseLibrary.getDataFromDatabase("select * from vtiger_data","username" );


		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		webDriverUtility.navigateApp(url, driver);
		webDriverUtility.browserSetting(driver, 10);
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		lp.loginAction(username, password);
		
		hp.homePageOrganizationAction();
		
		op.createNewOrganization();
		
		cnop.enterTheOrganizationName(organizationaName);
		
		cnop.saveTheOrganization();
				String text= oip.getcreatedOrgnizationName();
		System.out.println(text);
		jutil.assertionThroughIfCondition(text, organizationaName, organizationaName);
		hp.signOutIconMouseHoverAction(driver);
		
		webDriverUtility.quitBrowser(driver);
	}


}
