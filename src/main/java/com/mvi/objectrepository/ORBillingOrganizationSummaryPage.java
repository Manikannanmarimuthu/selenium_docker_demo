package com.mvi.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mvi.pages.AbstractPage;

public abstract class ORBillingOrganizationSummaryPage extends AbstractPage {

	public ORBillingOrganizationSummaryPage(WebDriver driver) {
		super(driver);
	}

//  Billing Organization Verification Summary Details

	@FindBy(css = "#msg")
	protected WebElement getTextBillOrgSuccessMessage;

	@FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(3) > div:nth-child(3) > label:nth-child(1)")
	protected WebElement getUENNo;

	@FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(4) > div:nth-child(3) > label:nth-child(1)")
	protected WebElement getBillingOrganization;

	@FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(5) > div:nth-child(3) > label:nth-child(1)")
	protected WebElement getEffectiveDate;

	@FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(6) > div:nth-child(3) > label:nth-child(1)")
	protected WebElement getBillingPurpose;

	@FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(7) > div:nth-child(3) > label:nth-child(1)")
	protected WebElement getAccountNumber;

	@FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(8) > div:nth-child(3) > label:nth-child(1)")
	protected WebElement getStatus;

}
