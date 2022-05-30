package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTestData {
	public static void main(String[]args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 Sheet sheet = wb.getSheet("Contacts");
			 Row row = sheet.getRow(4);
			 
			 Cell cell= row.getCell(1);
			 Random rand = new Random();
			 int Random = rand.nextInt(10000);
			 
			 String Organization_name = cell.getStringCellValue()+Random;
			
			 System.out.println(Organization_name);
			 Row row1= sheet.getRow(4);
			 Cell cell2 = row1.getCell(2);
			
			  String contact = cell2.getStringCellValue()+Random;
			
			System.out.println(contact);
			 
			 
	}
}
