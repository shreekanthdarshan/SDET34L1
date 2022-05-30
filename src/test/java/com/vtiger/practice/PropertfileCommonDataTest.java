package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertfileCommonDataTest {
	public static void main(String[]args) throws IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
	 Properties property = new Properties();
	 property.load(fis);
	 String url = property.getProperty("url");
	 System.out.println(url);
	 String username = property.getProperty("username");
	 System.out.println(username);
	 String pasword = property.getProperty("pasword");
	 System.out.println(pasword);
	 String browser = property.getProperty("browser");
	 System.out.println(browser);
	 String timeout = property.getProperty("timeout");
	 long ten = Long.parseLong(timeout);
	 System.out.println(ten);


}
}
