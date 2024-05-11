package com.mvi.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.constants.BIZOPSUIMessageConstants;
import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORReviewBillingOrganizationSummaryPage;
import com.mvi.utils.DateUtils;

public class ReviewBillingOrganizationSummaryPage extends ORReviewBillingOrganizationSummaryPage {

	public ReviewBillingOrganizationSummaryPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.getTextSuccessMessage));
		return this.getTextSuccessMessage.isDisplayed();
	}

	public boolean verifyReviewBillingOrganizationSummaryPagePartOne(String uen, String accountName) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getTextSuccessMessage, WaitStrategy.VISIBLE,
				BIZOPSUIMessageConstants.BILLING_ORGANIZATION_CHECKER_SUCCESS_MSG.trim()));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getUENNo, WaitStrategy.VISIBLE, uen));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingOrganization, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.getCurrentLocalDateTimeStamp("dd-MM-yyyy")));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}
	
	public boolean verifyEditReviewBillingOrganizationSummaryPagePartOne(String uen, String accountName) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getTextSuccessMessage, WaitStrategy.VISIBLE,
				BIZOPSUIMessageConstants.BILLING_ORGANIZATION_CHECKER_SUCCESS_MSG.trim()));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getUENNo, WaitStrategy.VISIBLE, uen));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingOrganization, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.addOrMinusDays("dd-MM-yyyy",1)));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}
	
	public boolean verifyFutureReviewBillingOrganizationSummaryPagePartOne(String uen, String accountName) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getTextSuccessMessage, WaitStrategy.VISIBLE,
				BIZOPSUIMessageConstants.BILLING_ORGANIZATION_CHECKER_SUCCESS_MSG.trim()));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getUENNo, WaitStrategy.VISIBLE, uen));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingOrganization, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.addOrMinusDays("dd-MM-yyyy",10)));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}
	
	public boolean verifyEditReviewBillingOrgRejectSummaryPagePartOne(String uen, String accountName) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getTextSuccessMessage, WaitStrategy.VISIBLE,
				BIZOPSUIMessageConstants.BILLING_ORGANIZATION_CHECKER_REJECT_MSG.trim()));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getUENNo, WaitStrategy.VISIBLE, uen));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingOrganization, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.addOrMinusDays("dd-MM-yyyy",1)));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}
	
	
	public boolean verifyReviewBillingOrganizationRejectSummaryPagePartOne(String uen, String accountName) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getTextSuccessMessage, WaitStrategy.VISIBLE,
				BIZOPSUIMessageConstants.BILLING_ORGANIZATION_CHECKER_REJECT_MSG.trim()));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getUENNo, WaitStrategy.VISIBLE, uen));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingOrganization, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.getCurrentLocalDateTimeStamp("dd-MM-yyyy")));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyReviewBillingOrganizationSummaryPagePartTwo(String billPurp, String accountNo,
			String status) {
		List<Boolean> verifyMakerBillingOrganizationSummaryPage = new ArrayList<>();
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getBillingPurpose, WaitStrategy.VISIBLE, billPurp));
		verifyMakerBillingOrganizationSummaryPage
				.add(verifyExactText(this.getAccountNumber, WaitStrategy.VISIBLE, accountNo));
		verifyMakerBillingOrganizationSummaryPage.add(verifyExactText(this.getStatus, WaitStrategy.VISIBLE, status));
		boolean isAllTrue = verifyMakerBillingOrganizationSummaryPage.stream().allMatch(n -> n == true);
		return isAllTrue;
	}
	
	

}
