package com.vtiger.campajnsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.vtiger.ObjectRep.CampaignPage;
import com.vtiger.ObjectRep.CreateNewCampignPage;
import com.vtiger.ObjectRep.CreateNewProductPage;
import com.vtiger.ObjectRep.ProductInformationPage;
import com.vtiger.ObjectRep.ProductPage;

public class CreateCapigenswithProductTest extends BaseClass {
	@Test(groups={"sanity","regression"})

	public void createCapigenswithProductTest() throws EncryptedDocumentException, IOException, InterruptedException {

		String product_name = msExcelUtility.getDataFromExcel("Product", 2, 1)+Random;
		System.out.println(product_name);
		String capigens_name = msExcelUtility.getDataFromExcel("Campigens", 2, 1)+Random;
		System.out.println(capigens_name);

		ProductPage pp = new ProductPage(driver);
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		ProductInformationPage pimp = new ProductInformationPage(driver);
		CampaignPage cp = new CampaignPage(driver);
		CreateNewCampignPage cncp = new CreateNewCampignPage(driver);

		hp.HomePageProductLink();

		pp.productPageAction();

		cnpp.createNewProductAction(product_name);
		cnpp.saveProduct();

		String product = pimp.createdProductName();
		jutil.assertionThroughIfCondition(product, product_name, product_name);
		
		hp.HompageMoreLink(driver);
		hp.HomepageCampaignsLink();


		cp.campaignPageAction();

		cncp.createCampaignPageAction(capigens_name);


		String Parent_id = driver.getWindowHandle();
		jutil.prinStatement(Parent_id);
		cncp.addproductBtn();
        cncp.switchToChild(driver, "Products&action");
		cncp.insideChildBrowserAction(product, driver);
		Thread.sleep(2000);
		cncp.switchToParent(driver, "Campaigns&action");




	}


}	




