package com.mvi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORCreateBillingOrganizationPage;
import com.mvi.utils.Common;
import com.mvi.utils.DateUtils;

public class CreateBillingOrganizationPage extends ORCreateBillingOrganizationPage {

	public CreateBillingOrganizationPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.btnCreateBillingOrganization));
		return this.btnCreateBillingOrganization.isDisplayed();
	}

	public void enterBillingDetails(String billPurpose, String custRefFmt1, String custRefFmt2, String custRefDesc,
			String billDescription) {
		click(WaitStrategy.CLICKABLE, this.btnCreateBillingOrganization);
		type(this.txtBillPurpose, WaitStrategy.VISIBLE, billPurpose);
		type(this.txtCustRefFmt1, WaitStrategy.VISIBLE, custRefFmt1);
		type(this.txtCustRefFmt2, WaitStrategy.VISIBLE, custRefFmt2);
		type(this.txtCustRefDesc, WaitStrategy.VISIBLE, custRefDesc);
		type(this.txtBillDescription, WaitStrategy.VISIBLE, billDescription);
	}

	public void selectFutureEffectiveDate() {
		typeAndTab(this.getEffectDate, WaitStrategy.VISIBLE, DateUtils.addOrMinusDays("dd-MM-yyyy", 10));
	}

	public void enterCreditPartyDetails(String uen, String accountName, String accountNumber,
			String creditPartyBankName) {
		type(this.txtUen, WaitStrategy.VISIBLE, uen);
		type(this.txtCreditPartyAccountName, WaitStrategy.VISIBLE, accountName);
		type(this.txtCreditPartyAccountNumber, WaitStrategy.VISIBLE, accountNumber);
		selectValueFromDropDown(this.clkCreditorpartyBankName, this.txtCreditorpartyBankName, creditPartyBankName,
				this.sltCreditPartyBankName);
	}

	public void enterRequesterCommentsAndClickSubmit(String requesterComments) {
		type(this.txtAreaRequesterComments, WaitStrategy.VISIBLE, requesterComments);
		click(WaitStrategy.VISIBLE, this.btnSubmit);
	}

	public void clickConfrmYesPopup() {
		Common.wait(2);
		click(WaitStrategy.VISIBLE, this.btnYesPopUp);
	}

}
