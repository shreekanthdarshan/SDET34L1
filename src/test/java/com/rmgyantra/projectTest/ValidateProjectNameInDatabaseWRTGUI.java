package com.rmgyantra.projectTest;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.SDET34L1.genricutility.IconstantPath;
import com.SDET34L1.genricutility.MsExcelUtility;
import com.SDET34L1.genricutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInDatabaseWRTGUI {

	
	public static void main(String[]args) throws SQLException, IOException {
	 WebDriver driver=null;
	 String projectName="Chandan_rayaapa";
	 Connection connection=null;
	 MsExcelUtility msExcelUtility = new MsExcelUtility();
	 WebDriverUtility webDriverUtility = new WebDriverUtility();
	
		msExcelUtility.openExcel(IconstantPath.RMGYEXCELPATH);
		WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  webDriverUtility.browserSetting(driver, 10);
		 /*driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		 driver.get("http://localhost:8084");
		 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rmgyantra");
		 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[.='Sign in']")).click();
		 driver.findElement(By.xpath("//a[.='Projects']")).click();
		 driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		 driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(msExcelUtility.getDataFromExcel("RMG", 1, 1));
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementByName()");
		 driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Sri");
		 WebElement ele = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		 Select s= new Select(ele);
		 s.selectByIndex(2);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		ResultSet result;
	
		
		
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
	    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
	    Statement statement = connection.createStatement();
	    result = statement.executeQuery("select project_name from project;");
	    while(result.next())
	    {
	    if(result.getString("project_name").equalsIgnoreCase(projectName)) 
	    {
	    System.out.println("ProjectName present in the Database"); 
	    System.out.println("TC pass");
	    
	    }
	    }
	
		
		
			connection.close();
		
		
	}
	

}

