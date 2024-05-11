package com.mvi.tests.billingorganization;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mvi.constants.BIZOPSUIConstants;
import com.mvi.pages.BillingOrganizationPreviewPage;
import com.mvi.pages.BillingOrganizationSummaryPage;
import com.mvi.pages.CreateBillingOrganizationPage;
import com.mvi.pages.HomePage;
import com.mvi.pages.LoginPage;
import com.mvi.pages.ReviewBillingOrganizationPage;
import com.mvi.pages.ReviewBillingOrganizationSearchPage;
import com.mvi.pages.ReviewBillingOrganizationSummaryPage;
import com.mvi.tests.AbstractTest;
import com.mvi.tests.ExcelReader;
import com.mvi.tests.billingorganization.model.BillingOrganization;
import com.mvi.util.Config;
import com.mvi.util.Constants;
import com.mvi.util.JsonUtil;

public class BillingOrgNegativeTest extends AbstractTest {

	private BillingOrganization testData;

	@BeforeTest()
	@Parameters({ "workBookName", "sheetName", "tcID" })
	public void setPageObjects(String workBookName, String sheetName, String tcID) {
		this.testData = JsonUtil.getTestData((new ExcelReader().generateJsonFile(BIZOPSUIConstants.getUiTestdataBaseDir()+ workBookName, sheetName, tcID)),
				BillingOrganization.class);
	}

	@Test()
	public void logInAndNavigateMakerBillingOrg() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		loginPage.launchCIMBApp(Config.get(Constants.CIMB_BIZOPS_UI_URL));
		Assert.assertTrue(loginPage.isAt());
		loginPage.loginAsMaker();
		Assert.assertTrue(homePage.isAt());
		homePage.navigateToBillingOrg();
	}

	@Test(dependsOnMethods = "logInAndNavigateMakerBillingOrg")
	public void createBillingOrganization() {
		CreateBillingOrganizationPage createBillOrg = new CreateBillingOrganizationPage(driver);
		Assert.assertTrue(createBillOrg.isAt());
		createBillOrg.enterBillingDetails(testData.BillingPurpose(), testData.CustomerReferenceFormat1(),
				testData.CustomerReferenceFormat2(), testData.CustomerReferenceDescription(),
				testData.BillingDescription());
		createBillOrg.enterCreditPartyDetails(testData.UEN(), testData.AccountName(), testData.AccountNumber(),
				testData.BankName());
		createBillOrg.enterRequesterCommentsAndClickSubmit(testData.RequesterComments());
		createBillOrg.clickConfrmYesPopup();
	}

	@Test(dependsOnMethods = "createBillingOrganization")
	public void verfiypreviewPage() {
		BillingOrganizationPreviewPage billingOrgPreviewPage = new BillingOrganizationPreviewPage(driver);
		Assert.assertTrue(billingOrgPreviewPage.isAt());
		billingOrgPreviewPage.verifyMakerBillingOrgPreviewPagePartOne(testData.BillingPurpose(),
				testData.CustomerReferenceFormat1(), testData.CustomerReferenceFormat2());
		billingOrgPreviewPage.verifyMakerBillingOrgPreviewPageTwo(testData.CustomerReferenceDescription(),
				testData.BillingDescription(), testData.UEN());
		billingOrgPreviewPage.verifyMakerBillingOrgPreviewPageThree(testData.AccountName(), testData.AccountNumber(),
				testData.BankName(), testData.RequesterComments());
		billingOrgPreviewPage.clickConfrm();
	}

	@Test(dependsOnMethods = "verfiypreviewPage")
	public void verfiyBillingOrgSummaryPage() {
		BillingOrganizationSummaryPage billingOrgSummaryPage = new BillingOrganizationSummaryPage(driver);
		Assert.assertTrue(billingOrgSummaryPage.isAt());
		billingOrgSummaryPage.verifyMakerBillingOrganizationSummaryPagePartOne(testData.UEN(), testData.AccountName());
		billingOrgSummaryPage.verifyMakerBillingOrganizationSummaryPagePartTwo(testData.BillingPurpose(),
				testData.AccountNumber(), testData.MakerSummaryStatus());
	}

	@Test(dependsOnMethods = "verfiyBillingOrgSummaryPage")
	public void logOutFromMaker() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isAt());
		homePage.logOutFromApp();
	}

	@Test(dependsOnMethods = "logOutFromMaker")
	public void logInAndNavigateReviewBillingOrg() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(loginPage.isAt());
		loginPage.loginAsChecker();
		Assert.assertTrue(homePage.isAt());
		homePage.navigateToReviewBillingOrg();
	}

	@Test(dependsOnMethods = "logInAndNavigateReviewBillingOrg")
	public void enterUenAndClickViewIcon() {
		ReviewBillingOrganizationSearchPage revBillOrgSearchPage = new ReviewBillingOrganizationSearchPage(driver);
		Assert.assertTrue(revBillOrgSearchPage.isAt());
		revBillOrgSearchPage.enterUENAndClickSearchButton(testData.UEN());
		revBillOrgSearchPage.clickViewBillOrgDetailsIcon();
	}

	@Test(dependsOnMethods = "enterUenAndClickViewIcon")
	public void verifyAndApproveReviewBillingOrgPageAnd() {
		ReviewBillingOrganizationPage revBillOrgPage = new ReviewBillingOrganizationPage(driver);
		Assert.assertTrue(revBillOrgPage.isAt());
		revBillOrgPage.verifyCheckerBillingOrgReviewPagePartOne(testData.BillingPurpose(),
				testData.CustomerReferenceFormat1(), testData.CustomerReferenceFormat2());
		revBillOrgPage.verifyCheckerBillingOrgReviewPageTwo(testData.CustomerReferenceDescription(),
				testData.BillingDescription(), testData.UEN());
		revBillOrgPage.verifyCheckerBillingOrgReviewPageThree(testData.AccountName(), testData.AccountNumber(),
				testData.BankName(), testData.RequesterComments());
	}

	@Test(dependsOnMethods = "verifyAndApproveReviewBillingOrgPageAnd")
	public void enterReviewerCommentsAndReject() {
		ReviewBillingOrganizationPage revBillOrgPage = new ReviewBillingOrganizationPage(driver);
		revBillOrgPage.enterReviewCommentsAndclickRejectBtn(testData.ReviewerComments());
		revBillOrgPage.clickYesPopup();
	}

	@Test(dependsOnMethods = "enterReviewerCommentsAndSubmit")
	public void verifyReviewBillingOrgSummaryPage() {
		ReviewBillingOrganizationSummaryPage revBillingOrgSummaryPage = new ReviewBillingOrganizationSummaryPage(
				driver);
		Assert.assertTrue(revBillingOrgSummaryPage.isAt());
		revBillingOrgSummaryPage.verifyReviewBillingOrganizationSummaryPagePartOne(testData.UEN(),
				testData.AccountName());
		revBillingOrgSummaryPage.verifyReviewBillingOrganizationSummaryPagePartTwo(testData.BillingPurpose(),
				testData.AccountNumber(), testData.CheckerSummaryStatus());
	}

	@Test(dependsOnMethods = "verifyReviewBillingOrgSummaryPage")
	public void logOutFromChecker() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isAt());
		homePage.logOutFromApp();
	}

}