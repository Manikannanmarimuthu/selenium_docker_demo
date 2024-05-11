package com.mvi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.OREditBillingOrganizationPage;
import com.mvi.utils.DateUtils;

public class EditBillingOrganizationPage extends OREditBillingOrganizationPage {

	public EditBillingOrganizationPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.TxtProcessingScheme));
		return this.TxtProcessingScheme.isDisplayed();
	}

	public void editBillingDetails(String editCustRefFmt1, String editCustRefFmt2, String editCustRefDesc,
			String editBillDescription) {
		typeAndTab(this.getEffectDate, WaitStrategy.VISIBLE, DateUtils.addOrMinusDays("dd-MM-yyyy", 1));
		type(this.txtCustRefFmt1, WaitStrategy.VISIBLE, editCustRefFmt1);
		type(this.txtCustRefFmt2, WaitStrategy.VISIBLE, editCustRefFmt2);
		type(this.txtCustRefDesc, WaitStrategy.VISIBLE, editCustRefDesc);
		type(this.txtBillDescription, WaitStrategy.VISIBLE, editBillDescription);
	}

	public void editCreditPartyDetails(String editAccountNumber, String editCreditPartyBankName) {
		type(this.txtCreditPartyAccountNumber, WaitStrategy.VISIBLE, editAccountNumber);
		selectValueFromDropDown(this.clkCreditorpartyBankName, this.txtCreditorpartyBankName, editCreditPartyBankName,
				this.sltCreditPartyBankName);
	}

	public void enterNewRequesterCommentsAndClickSubmit(String requesterComments) {
		type(this.txtAreaRequesterComments, WaitStrategy.VISIBLE, requesterComments);
		click(WaitStrategy.VISIBLE, this.btnSubmit);
	}

	public void clickConfrmYesPopup() {
		click(WaitStrategy.VISIBLE, this.btnYesPopUp);
	}

}
