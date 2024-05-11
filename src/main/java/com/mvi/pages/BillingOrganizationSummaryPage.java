package com.mvi.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.constants.BIZOPSUIMessageConstants;
import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORBillingOrganizationSummaryPage;
import com.mvi.utils.DateUtils;

public class BillingOrganizationSummaryPage extends ORBillingOrganizationSummaryPage {

	public BillingOrganizationSummaryPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.getTextBillOrgSuccessMessage));
		return this.getTextBillOrgSuccessMessage.isDisplayed();
	}

	public boolean verifyMakerBillingOrganizationSummaryPagePartOne(String uen, String accountName) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getTextBillOrgSuccessMessage,
				WaitStrategy.VISIBLE, BIZOPSUIMessageConstants.BILLING_ORGANIZATION_MAKER_SUCCESS_MSG.trim()));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getUENNo, WaitStrategy.VISIBLE, uen));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingOrganization, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.getCurrentLocalDateTimeStamp("dd-MM-yyyy")));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyFutureBillingOrganizationSummaryPagePartOne(String uen, String accountName) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getTextBillOrgSuccessMessage,
				WaitStrategy.VISIBLE, BIZOPSUIMessageConstants.BILLING_ORGANIZATION_MAKER_SUCCESS_MSG.trim()));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getUENNo, WaitStrategy.VISIBLE, uen));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingOrganization, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.addOrMinusDays("dd-MM-yyyy", 10)));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyMakerBillingOrganizationSummaryPagePartTwo(String billPurp, String accountNo, String status) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingPurpose, WaitStrategy.VISIBLE, billPurp));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getAccountNumber, WaitStrategy.VISIBLE, accountNo));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getStatus, WaitStrategy.VISIBLE, status));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyEditBillingOrganizationSummaryPagePartOne(String uen, String accountName) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getTextBillOrgSuccessMessage, WaitStrategy.VISIBLE,
						BIZOPSUIMessageConstants.BILLING_ORGANIZATION_DETAILS_ACTIVE_REQUEST_SUBMITTED_SUCCESSFULLY_MSG
								.trim()));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getUENNo, WaitStrategy.VISIBLE, uen));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingOrganization, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.addOrMinusDays("dd-MM-yyyy", 1)));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

}
