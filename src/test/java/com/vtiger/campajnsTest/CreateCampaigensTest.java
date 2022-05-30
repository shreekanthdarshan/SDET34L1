
package com.vtiger.campajnsTest;


import java.io.IOException;

import org.testng.annotations.Test;

import com.SDET34L1.genricutility.BaseClass;
import com.vtiger.ObjectRep.CampaignInforamationPage;
import com.vtiger.ObjectRep.CampaignPage;
import com.vtiger.ObjectRep.CreateNewCampignPage;

public class CreateCampaigensTest extends BaseClass {
	@Test(groups={"sanity","regression"})
	public  void createCampaigensTest() throws IOException, InterruptedException {
		String campaignmae =msExcelUtility.getDataFromExcel("Campigens", 2, 1);		
		CampaignPage cp = new CampaignPage(driver);
		CreateNewCampignPage cncp = new CreateNewCampignPage(driver);
		CampaignInforamationPage cip = new CampaignInforamationPage(driver);
		webDriverUtility.initalizeTheAction(driver);

		hp.HompageMoreLink(driver);
		Thread.sleep(2000);
		hp.HomepageCampaignsLink();

		cp.campaignPageAction();

		cncp.createCampaignPageAction(campaignmae);

		cp.campaignsave();

		String text = cip.createdCampaignNameText();
		jutil.prinStatement(text);
		jutil.assertionThroughIfCondition(text, campaignmae, campaignmae);




	}

}

