package com.vtiger.productTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.SDET34L1.genricutility.JavaUtility;
import com.vtiger.ObjectRep.CreateNewProductPage;
import com.vtiger.ObjectRep.ProductInformationPage;
import com.vtiger.ObjectRep.ProductPage;

public class CreateProductTest extends BaseClass {
	@Test(groups={"sanity","regression"})
	public void createProductTest() throws IOException {

		JavaUtility jutil = new JavaUtility();
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
