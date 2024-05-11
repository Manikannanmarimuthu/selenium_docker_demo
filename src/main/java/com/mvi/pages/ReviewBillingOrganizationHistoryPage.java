package com.mvi.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORReviewBillingOrganizationHistoryPage;
import com.mvi.utils.DateUtils;

public class ReviewBillingOrganizationHistoryPage extends ORReviewBillingOrganizationHistoryPage {

	public ReviewBillingOrganizationHistoryPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.btnBillOrgHistory));
		return this.btnBillOrgHistory.isDisplayed();
	}

	public void reviewBillingOrganizationHistoryBtn() {
		click(WaitStrategy.VISIBLE, this.btnBillOrgHistory);
	}

	public boolean verifyReviewBillingOrgHistoryPageOne(String custRefFormat1, String custRefFormat2,
			String custRefDesc) {
		List<Boolean> verifyBillingOrgHistoryPageOne = new ArrayList<>();
		verifyBillingOrgHistoryPageOne
				.add(verifyExactText(this.getBoHistoryCustomerRefFormat1, WaitStrategy.VISIBLE, custRefFormat1));
		verifyBillingOrgHistoryPageOne
				.add(verifyExactText(this.getBoHistoryCustomerRefFormat2, WaitStrategy.VISIBLE, custRefFormat2));
		verifyBillingOrgHistoryPageOne
				.add(verifyExactText(this.getBoHistoryCustomerRefDescription, WaitStrategy.VISIBLE, custRefDesc));
		boolean isAllTrue = verifyBillingOrgHistoryPageOne.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyReviewBillingOrgHistoryPageTwo(String billDesc, String uen, String accountName,
			String accountNo) {
		List<Boolean> verifyBillingOrgHistoryPageTwo = new ArrayList<>();
		verifyBillingOrgHistoryPageTwo
				.add(verifyExactText(this.getBoHistoryBillingDescription, WaitStrategy.VISIBLE, billDesc));
		verifyBillingOrgHistoryPageTwo.add(verifyExactText(this.getBoHistoryUen, WaitStrategy.VISIBLE, uen));
		verifyBillingOrgHistoryPageTwo
				.add(verifyExactText(this.getBoHistoryAccountName, WaitStrategy.VISIBLE, accountName));
		verifyBillingOrgHistoryPageTwo
				.add(verifyExactText(this.getBoHistoryAccountNo, WaitStrategy.VISIBLE, accountNo));
		boolean isAllTrue = verifyBillingOrgHistoryPageTwo.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyReviewBillingOrgHistoryPageThree(String creditorBankCode, String status,
			String billingPurpose) {
		List<Boolean> verifyBillingOrgHistoryPageTwo = new ArrayList<>();
		verifyBillingOrgHistoryPageTwo
				.add(verifyExactText(this.getBoHistoryCreditorBankCode, WaitStrategy.VISIBLE, creditorBankCode));
		verifyBillingOrgHistoryPageTwo.add(verifyExactText(this.getBoHistoryEffectiveDate, WaitStrategy.VISIBLE,
				DateUtils.addOrMinusDays("dd-MM-yyyy", 0)));
		verifyBillingOrgHistoryPageTwo.add(verifyExactText(this.getBoHistoryStatus, WaitStrategy.VISIBLE, status));
		verifyBillingOrgHistoryPageTwo
				.add(verifyExactText(this.getBoHistoryBillingPurpose, WaitStrategy.VISIBLE, billingPurpose));
		boolean isAllTrue = verifyBillingOrgHistoryPageTwo.stream().allMatch(n -> n == true);
		return isAllTrue;
	}
	
	public void reviewBillingOrganizationHistoryBackBtn() {
		click(WaitStrategy.VISIBLE, this.getBoHistoryBackBtn);
	}
}
