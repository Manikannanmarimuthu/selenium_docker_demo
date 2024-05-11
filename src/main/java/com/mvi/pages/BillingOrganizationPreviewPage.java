package com.mvi.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORBillingOrganizationPreviewPage;
import com.mvi.utils.DateUtils;

public class BillingOrganizationPreviewPage extends ORBillingOrganizationPreviewPage {

	public BillingOrganizationPreviewPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.TxtProcessingScheme));
		return this.TxtProcessingScheme.isDisplayed();
	}

	public boolean verifyMakerBillingOrgPreviewPagePartOne(String billPurp, String custRefformat1,
			String custRefformat2) {
		List<Boolean> verifyMakerBillingOrgPreviewPagePartOne = new ArrayList<>();
		verifyMakerBillingOrgPreviewPagePartOne
				.add(verifyExactTextUsingValueAttribute(this.getTxtBillPurpose, WaitStrategy.VISIBLE, billPurp));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(this.getTxtEffectiveDate,
				WaitStrategy.VISIBLE, DateUtils.getCurrentLocalDateTimeStamp("dd-MM-yyyy")));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat1, WaitStrategy.VISIBLE, custRefformat1));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat2, WaitStrategy.VISIBLE, custRefformat2));
		boolean isAllTrue = verifyMakerBillingOrgPreviewPagePartOne.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyFutureBillingOrgPreviewPagePartOne(String billPurp, String custRefformat1,
			String custRefformat2) {
		List<Boolean> verifyMakerBillingOrgPreviewPagePartOne = new ArrayList<>();
		verifyMakerBillingOrgPreviewPagePartOne
				.add(verifyExactTextUsingValueAttribute(this.getTxtBillPurpose, WaitStrategy.VISIBLE, billPurp));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(this.getTxtEffectiveDate,
				WaitStrategy.VISIBLE, DateUtils.addOrMinusDays("dd-MM-yyyy", 10)));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat1, WaitStrategy.VISIBLE, custRefformat1));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat2, WaitStrategy.VISIBLE, custRefformat2));
		boolean isAllTrue = verifyMakerBillingOrgPreviewPagePartOne.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyMakerBillingOrgPreviewPageTwo(String custRefDesc, String billingDesc, String uen) {
		List<Boolean> verifyMakerBillingOrgPreviewPageTwo = new ArrayList<>();
		verifyMakerBillingOrgPreviewPageTwo.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceDescription, WaitStrategy.VISIBLE, custRefDesc));
		verifyMakerBillingOrgPreviewPageTwo.add(
				verifyExactTextUsingValueAttribute(this.getTxtBillingDescription, WaitStrategy.VISIBLE, billingDesc));
		verifyMakerBillingOrgPreviewPageTwo
				.add(verifyExactTextUsingValueAttribute(this.getTxtUen, WaitStrategy.VISIBLE, uen));
		boolean isAllTrue = verifyMakerBillingOrgPreviewPageTwo.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyMakerBillingOrgPreviewPageThree(String accountName, String accountNo, String bankName,
			String reqComments) {
		List<Boolean> verifyMakerBillingOrgPreviewPageThree = new ArrayList<>();
		verifyMakerBillingOrgPreviewPageThree
				.add(verifyExactTextUsingValueAttribute(this.getTxtAccountName, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrgPreviewPageThree
				.add(verifyExactTextUsingValueAttribute(this.getTxtAccountNumber, WaitStrategy.VISIBLE, accountNo));
		verifyMakerBillingOrgPreviewPageThree
				.add(verifySelectedText(this.getTxtBankName, WaitStrategy.VISIBLE, bankName));
		verifyMakerBillingOrgPreviewPageThree.add(
				verifyExactTextUsingValueAttribute(this.getTxtRequesterComments, WaitStrategy.VISIBLE, reqComments));
		boolean isAllTrue = verifyMakerBillingOrgPreviewPageThree.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public void clickConfrm() {
		click(WaitStrategy.CLICKABLE, this.btnConfirm);
	}

	public boolean verifyMakerEditBillingOrgPreviewPagePartOne(String billPurp, String custRefformat1,
			String custRefformat2) {
		List<Boolean> verifyMakerBillingOrgPreviewPagePartOne = new ArrayList<>();
		verifyMakerBillingOrgPreviewPagePartOne
				.add(verifyExactTextUsingValueAttribute(this.getTxtBillPurpose, WaitStrategy.VISIBLE, billPurp));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(this.getTxtEffectiveDate,
				WaitStrategy.VISIBLE, DateUtils.addOrMinusDays("dd-MM-yyyy", 1)));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat1, WaitStrategy.VISIBLE, custRefformat1));
		verifyMakerBillingOrgPreviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat2, WaitStrategy.VISIBLE, custRefformat2));
		boolean isAllTrue = verifyMakerBillingOrgPreviewPagePartOne.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

}
