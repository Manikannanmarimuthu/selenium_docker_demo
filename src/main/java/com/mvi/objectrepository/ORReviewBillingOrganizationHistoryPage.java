package com.mvi.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mvi.pages.AbstractPage;

public abstract class ORReviewBillingOrganizationHistoryPage extends AbstractPage {

	public ORReviewBillingOrganizationHistoryPage(WebDriver driver) {
		super(driver);
	}

// Review Billing Organization History Details

	@FindBy(xpath = "//a[@id='nav-gpiTranDtl-dct-tab']")   
	protected WebElement btnBillOrgHistory;

	@FindBy(xpath = "//tr[@class='odd']//td[2]")
	protected WebElement getBoHistoryCustomerRefFormat1;

	@FindBy(xpath = "//tr[@class='odd']//td[3]")
	protected WebElement getBoHistoryCustomerRefFormat2;

	@FindBy(xpath = "//tr[@class='odd']//td[4]")
	protected WebElement getBoHistoryCustomerRefDescription;

	@FindBy(xpath = "//tr[@class='odd']//td[5]")
	protected WebElement getBoHistoryBillingDescription;

	@FindBy(xpath = "//tr[@class='odd']//td[6]")
	protected WebElement getBoHistoryUen;
	
	@FindBy(xpath = "//tr[@class='odd']//td[7]")
	protected WebElement getBoHistoryAccountName;

	@FindBy(xpath = "//tr[@class='odd']//td[8]")
	protected WebElement getBoHistoryAccountNo;
	
	@FindBy(xpath = "//tr[@class='odd']//td[9]")
	protected WebElement getBoHistoryCreditorBankCode; 
	
	@FindBy(xpath = "//tr[@class='odd']//td[10]")
	protected WebElement getBoHistoryEffectiveDate;
	
	@FindBy(xpath = "//tr[@class='odd']//td[12]")
	protected WebElement getBoHistoryStatus;

	@FindBy(xpath = "//tr[@class='odd']//td[13]")
	protected WebElement getBoHistoryBillingPurpose;
	
	@FindBy(xpath = "//button[@class='btn btn-dark btn-fill crtPgBtn']")
	protected WebElement getBoHistoryBackBtn;
}
