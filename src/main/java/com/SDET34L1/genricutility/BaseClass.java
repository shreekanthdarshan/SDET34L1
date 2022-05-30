package com.SDET34L1.genricutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.ObjectRep.HomePage;
import com.vtiger.ObjectRep.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public  WebDriver driver;
	public JavaUtility jutil;

	public String url ;
	public  String username;
	public String password;
	public String browser;
	public  long timeouts;
	public LoginPage lp ;
	public  HomePage hp ;
	public   int Random;
	public MsExcelUtility msExcelUtility;
	public PropertyFileUtility propertyFileUtility;
	public WebDriverUtility webDriverUtility ;
	public static WebDriver staticdriver;
	/**
	 * This method use to open the excel,propertyfile,Getconnection with datbase.
	 * @throws Throwable
	 */
	@BeforeSuite(groups="baseClass")
	public void beforeSuite() throws Throwable{



	}

	/**
	 * This method use to open the class,lanuch the browser navigate the application fetch the data from propertyfile  and browser Setting instance of common POM class
	 * @throws IOException
	 */

	//@Parameters(value="browser")
	@BeforeClass(groups="baseClass")
	public void beforClass() throws IOException {
		jutil=new JavaUtility();
		msExcelUtility= new MsExcelUtility();
		propertyFileUtility=new PropertyFileUtility();
		propertyFileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);

		msExcelUtility.openExcel(IconstantPath.EXCELPATH);
		url = propertyFileUtility.getDataFromPropertFile("url");
		System.out.println(url);
		username=propertyFileUtility.getDataFromPropertFile("username");
		System.out.println(username);
		password =propertyFileUtility.getDataFromPropertFile("pasword");
		browser = propertyFileUtility.getDataFromPropertFile("browser");
		String timeout = propertyFileUtility.getDataFromPropertFile("timeout");
		timeouts = jutil.stringToLong(timeout);
		Random = jutil.getRandomNumber(1000);

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			System.out.println("please specify proper browser key");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		}
		staticdriver=driver;
		webDriverUtility = new WebDriverUtility();
		webDriverUtility.navigateApp(url, driver);
		webDriverUtility.browserSetting(driver, timeouts);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);


	}

	/**
	 * This method use to login the application
	 */
	@BeforeMethod(groups="baseClass")
	public void beforMethod() {
		lp.loginAction(username, password);




	}

	/**
	 * This method use to logout the application
	 */
	@AfterMethod(groups="baseClass")
	public void afterMethpd() {
		hp.signOutIconMouseHoverAction(driver);
	}

	/**
	 * This method use to quit the browser
	 */
	@AfterClass(groups="baseClass")
	public void afterClass() {
		webDriverUtility.quitBrowser(driver);
	}
	/**
	 * This method use to close the excel,close dataBase
	 * @throws IOException
	 */
	@AfterSuite(groups="baseClass")
	public void afterSuite() throws IOException {
		msExcelUtility.saveExcel(IconstantPath.EXCELPATH);
		msExcelUtility.closeExcel();


	}


}
