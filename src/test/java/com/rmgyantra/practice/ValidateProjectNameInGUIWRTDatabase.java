package com.rmgyantra.practice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genricutility.DatabaseLibrary;
import com.SDET34L1.genricutility.IconstantPath;
import com.SDET34L1.genricutility.PropertyFileUtility;
import com.SDET34L1.genricutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInGUIWRTDatabase {
	
	public static void main(String[]args) throws SQLException, IOException {
	   // Connection connection=null;
		//String url="https://localhost:8084";
		PropertyFileUtility propertyFileUtility = new PropertyFileUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
	    propertyFileUtility.openPropertyFile(IconstantPath.RMGYPROPERTYFILEPATH);
	    String dbName = propertyFileUtility.getDataFromPropertFile("dbName");
	    System.out.println(dbName);
	    String projectName = propertyFileUtility.getDataFromPropertFile("projectName");
		
		
		WebDriver driver=null;
	
	
		
			
  DatabaseLibrary.openDbConnection(IconstantPath.MSQLPATH+dbName,propertyFileUtility.getDataFromPropertFile("dbuserName"),propertyFileUtility.getDataFromPropertFile("dbpassword"));
	 /* Driver d = new Driver();
	  DriverManager.registerDriver(d);
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
    Statement statement = connection.createStatement();*/
    DatabaseLibrary.setDataInDatabase("insert into project values('TY_PROJ_572','jai','28-04-2022','"+projectName+"','On Going',5);");
			
   //statement.executeUpdate("insert into project values('TY_PROJ_5071','jai','28-04-2022','"+projectName+"','On Going',5);");
	
	
		
		
	
		 WebDriverManager.firefoxdriver().setup();
	 driver = new FirefoxDriver();
	 webDriverUtility.navigateApp("http://localhost:8084", driver);
     webDriverUtility.browserSetting(driver, 10);
	 //driver.manage().window().maximize();
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 //driver.get("http://localhost:8084");
	 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rmgyantra");
	 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rmgy@9999");
	 driver.findElement(By.xpath("//button[.='Sign in']")).click();
	 
	 
	 driver.findElement(By.xpath("//a[.='Projects']")).click();
	List<WebElement> listofprojects= driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
	for(WebElement project:listofprojects) {
		if(project.getText().equalsIgnoreCase(projectName));
		{
			System.out.println("project Name is visible in GUI");
			System.out.println("TC pass");
			break;
		}
	
		
		
		
			
		
	
	}
	DatabaseLibrary.closeDatabase();
	driver.quit();
}
}
	


