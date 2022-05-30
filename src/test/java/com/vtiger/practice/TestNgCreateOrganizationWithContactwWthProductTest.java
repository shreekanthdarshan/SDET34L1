package com.vtiger.practice;

import java.io.IOException;

import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.SDET34L1.genricutility.IconstantPath;
import com.SDET34L1.genricutility.MsExcelUtility;
import com.SDET34L1.genricutility.PropertyFileUtility;
import com.vtiger.ObjectRep.CreateNewOrganizationPage;
import com.vtiger.ObjectRep.CreateNewProductPage;
import com.vtiger.ObjectRep.OrganizationInformationPage;
import com.vtiger.ObjectRep.OrganizationPage;
import com.vtiger.ObjectRep.ProductInformationPage;
import com.vtiger.ObjectRep.ProductPage;

public class TestNgCreateOrganizationWithContactwWthProductTest extends BaseClass {
	OrganizationPage op = new OrganizationPage(driver);
	CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	OrganizationInformationPage oIP = new OrganizationInformationPage(driver);

	@Test
	public void createOrganization() throws IOException {
		
		 msExcelUtility = new MsExcelUtility();
		propertyFileUtility = new PropertyFileUtility();
		propertyFileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);

		msExcelUtility.openExcel(IconstantPath.EXCELPATH);
		String organizationaName = msExcelUtility.getDataFromExcel("Organization", 2, 1)+Random;
		hp.homePageOrganizationAction();
		op.createNewOrganization();
		cnop.enterTheOrganizationName(organizationaName);
		cnop.saveTheOrganization();
		String text5=oIP.getcreatedOrgnizationName();
		System.out.println(text5);
		jutil.assertionThroughIfCondition(text5, organizationaName, organizationaName);
	}

	@Test
	public void createOraganizationAndAddIndusrty() throws IOException {
		 msExcelUtility = new MsExcelUtility();
			propertyFileUtility = new PropertyFileUtility();
			propertyFileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);

			msExcelUtility.openExcel(IconstantPath.EXCELPATH);
		String OraganizationName = msExcelUtility.getDataFromExcel("Organization",2 , 1)+Random;
		hp.homePageOrganizationAction();	
		op.createNewOrganization();
		cnop.enterTheOrganizationName(OraganizationName);
		cnop.industryDropDown("Education");
		cnop.waitUntilIndustryDropDownSelect(driver);
		cnop.accounttypeDropDown("Press");
		cnop.saveTheOrganization();
		String text= oIP.getcreatedOrgnizationName();
		System.out.println(text);
		jutil.assertionThroughIfCondition(text, OraganizationName, OraganizationName);

	}
	@Test
	public void createProduct() throws IOException {
		
		ProductPage pp = new ProductPage(driver);
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		ProductInformationPage pip = new ProductInformationPage(driver);
		String productname = msExcelUtility.getDataFromExcel("Product", 1, 0);
        hp.HomePageProductLink();
		pp.productPageAction();
        cnpp.createNewProductAction(productname);
		cnpp.saveProduct();
        String product = pip.createdProductName();		
		jutil.assertionThroughIfCondition(product, productname, productname);
		
	}




}





