package com.mvi.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORReviewBillingOrganizationPage;
import com.mvi.utils.Common;
import com.mvi.utils.DateUtils;

public class ReviewBillingOrganizationPage extends ORReviewBillingOrganizationPage {

	public ReviewBillingOrganizationPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.TxtProcessingScheme));
		return this.TxtProcessingScheme.isDisplayed();
	}

	public boolean verifyCheckerBillingOrgReviewPagePartOne(String billPurp, String custRefformat1,
			String custRefformat2) {
		List<Boolean> verifyCheckerBillingOrgReviewPagePartOne = new ArrayList<>();
		verifyCheckerBillingOrgReviewPagePartOne
				.add(verifyExactTextUsingValueAttribute(this.getTxtBillPurpose, WaitStrategy.VISIBLE, billPurp));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(this.getTxtEffectiveDate,
				WaitStrategy.VISIBLE, DateUtils.getCurrentLocalDateTimeStamp("dd-MM-yyyy")));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat1, WaitStrategy.VISIBLE, custRefformat1));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat2, WaitStrategy.VISIBLE, custRefformat2));
		boolean isAllTrue = verifyCheckerBillingOrgReviewPagePartOne.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyCheckerFutureBillingOrgReviewPagePartOne(String billPurp, String custRefformat1,
			String custRefformat2) {
		List<Boolean> verifyCheckerBillingOrgReviewPagePartOne = new ArrayList<>();
		verifyCheckerBillingOrgReviewPagePartOne
				.add(verifyExactTextUsingValueAttribute(this.getTxtBillPurpose, WaitStrategy.VISIBLE, billPurp));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(this.getTxtEffectiveDate,
				WaitStrategy.VISIBLE, DateUtils.addOrMinusDays("dd-MM-yyyy", 10)));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat1, WaitStrategy.VISIBLE, custRefformat1));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat2, WaitStrategy.VISIBLE, custRefformat2));
		boolean isAllTrue = verifyCheckerBillingOrgReviewPagePartOne.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyCheckerBillingOrgReviewPageTwo(String custRefDesc, String billingDesc, String uen) {
		Common.wait(5);
		List<Boolean> verifyCheckerBillingOrgReviewPageTwo = new ArrayList<>();
		verifyCheckerBillingOrgReviewPageTwo.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceDescription, WaitStrategy.VISIBLE, custRefDesc));
		verifyCheckerBillingOrgReviewPageTwo.add(
				verifyExactTextUsingValueAttribute(this.getTxtBillingDescription, WaitStrategy.VISIBLE, billingDesc));
		verifyCheckerBillingOrgReviewPageTwo
				.add(verifyExactTextUsingValueAttribute(this.getTxtUen, WaitStrategy.VISIBLE, uen));
		boolean isAllTrue = verifyCheckerBillingOrgReviewPageTwo.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyCheckerBillingOrgReviewPageThree(String accountName, String accountNo, String bankName,
			String reqComments) {
		List<Boolean> verifyMakerBillingOrgPreviewPageThree = new ArrayList<>();
		verifyMakerBillingOrgPreviewPageThree
				.add(verifyExactTextUsingValueAttribute(this.getTxtAccountName, WaitStrategy.VISIBLE, accountName));
		verifyMakerBillingOrgPreviewPageThree
				.add(verifyExactTextUsingValueAttribute(this.getTxtAccountNumber, WaitStrategy.VISIBLE, accountNo));
		Common.wait(5);
		verifyMakerBillingOrgPreviewPageThree
				.add(verifyExactTextUsingValueAttribute(this.getTxtBankName, WaitStrategy.VISIBLE, bankName));
		verifyMakerBillingOrgPreviewPageThree.add(
				verifyExactTextUsingValueAttribute(this.getTxtRequesterComments, WaitStrategy.VISIBLE, reqComments));

		boolean isAllTrue = verifyMakerBillingOrgPreviewPageThree.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public void enterRevCommentsAndclickApproveBtn(String revComments) {
		type(this.txtRevCom, WaitStrategy.VISIBLE, revComments);
		click(WaitStrategy.VISIBLE, this.btnApprove);
	}

	public void enterReviewCommentsAndclickRejectBtn(String revComments) {
		type(this.txtRevCom, WaitStrategy.VISIBLE, revComments);
		click(WaitStrategy.VISIBLE, this.btnReject);
	}

	public void clickYesPopup() {
		click(WaitStrategy.VISIBLE, this.btnYesPopUp);
	}

	public boolean verifyCheckerEditBillingOrgReviewPagePartOne(String billPurp, String custRefformat1,
			String custRefformat2) {
		List<Boolean> verifyCheckerBillingOrgReviewPagePartOne = new ArrayList<>();
		verifyCheckerBillingOrgReviewPagePartOne
				.add(verifyExactTextUsingValueAttribute(this.getTxtBillPurpose, WaitStrategy.VISIBLE, billPurp));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(this.getTxtEffectiveDate,
				WaitStrategy.VISIBLE, DateUtils.addOrMinusDays("dd-MM-yyyy", 1)));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat1, WaitStrategy.VISIBLE, custRefformat1));
		verifyCheckerBillingOrgReviewPagePartOne.add(verifyExactTextUsingValueAttribute(
				this.getTxtCustomerReferenceFormat2, WaitStrategy.VISIBLE, custRefformat2));
		boolean isAllTrue = verifyCheckerBillingOrgReviewPagePartOne.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public boolean verifyBillingOrgPreviousValuePartOne(String crf1, String crf2, String custRefDesc) {
		List<Boolean> verifyBillOrgPrevValue = new ArrayList<>();
		verifyBillOrgPrevValue.add(verifyExtractedAttributeValue(this.effectiveDatePreviousValue, WaitStrategy.VISIBLE,
				"data-original-title",DateUtils.addOrMinusDays("dd-MM-yyyy", 0)));
		verifyBillOrgPrevValue.add(verifyExtractedAttributeValue(this.custRefformat1PreviousValue, WaitStrategy.VISIBLE,
				"data-original-title",crf1));
		verifyBillOrgPrevValue.add(verifyExtractedAttributeValue(this.custRefformat2PreviousValue, WaitStrategy.VISIBLE,
				"data-original-title",crf2));
		verifyBillOrgPrevValue.add(verifyExtractedAttributeValue(this.custRefDescriptionPreviousValue, WaitStrategy.VISIBLE,
				"data-original-title",custRefDesc));
		boolean isAllTrue = verifyBillOrgPrevValue.stream().allMatch(n -> n == true);
		return isAllTrue;
	}
	
	public boolean verifyBillingOrgPreviousValuePartTwo(String billDesc, String accNo, String bankName) {
		List<Boolean> verifyBillOrgPrevValue = new ArrayList<>();
		verifyBillOrgPrevValue.add(verifyExtractedAttributeValue(this.billDescriptionPreviousValue, WaitStrategy.VISIBLE,
				"data-original-title",billDesc));
		verifyBillOrgPrevValue.add(verifyExtractedAttributeValue(this.creditPartyAccNoPreviousValue, WaitStrategy.VISIBLE,
				"data-original-title",accNo));
		verifyBillOrgPrevValue.add(verifyExtractedAttributeValue(this.creditPartyBankNamePreviousValue, WaitStrategy.VISIBLE,
				"data-original-title",bankName));
		boolean isAllTrue = verifyBillOrgPrevValue.stream().allMatch(n -> n == true);
		return isAllTrue;
	}
}
