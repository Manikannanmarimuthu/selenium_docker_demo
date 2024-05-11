package com.mvi.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mvi.pages.AbstractPage;

public abstract class ORBillingOrganizationPreviewPage extends AbstractPage {

	public ORBillingOrganizationPreviewPage(WebDriver driver) {
		super(driver);
	}

//	Maker Billing Organization Preview Page	
	
	@FindBy(xpath = "//button[text()='Confirm']")
	protected WebElement btnConfirm;
	
	@FindBy(xpath = "//input[@id='processScheme']")
	protected WebElement TxtProcessingScheme;  

	@FindBy(xpath = "//input[@id='billPurpose']")
	protected WebElement getTxtBillPurpose;

	@FindBy(xpath = "//input[@id='effectDt']")
	protected WebElement getTxtEffectiveDate;

	@FindBy(xpath = "//input[@id='custRefFmt1']")
	protected WebElement getTxtCustomerReferenceFormat1;

	@FindBy(xpath = "//input[@id='custRefFmt2']")
	protected WebElement getTxtCustomerReferenceFormat2;

	@FindBy(xpath = "//textarea[@id='custRefDesc']")
	protected WebElement getTxtCustomerReferenceDescription;

	@FindBy(xpath = "//textarea[@id='billdescription']")
	protected WebElement getTxtBillingDescription;

	@FindBy(xpath = "//input[@id='UEN']")
	protected WebElement getTxtUen;

	@FindBy(xpath = "//input[@id='cretName']")
	protected WebElement getTxtAccountName;

	@FindBy(xpath = "//input[@id='accNo']")
	protected WebElement getTxtAccountNumber;

	@FindBy(xpath = "//select[@id='bnkCode']")
	protected WebElement getTxtBankName;

	@FindBy(xpath = "//input[@id='bicCd']")
	protected WebElement getTxtBankCode;

	@FindBy(xpath = "//textarea[@id='rqstrCmts']")
	protected WebElement getTxtRequesterComments;
}
