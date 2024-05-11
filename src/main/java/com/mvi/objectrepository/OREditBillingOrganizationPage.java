package com.mvi.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mvi.pages.AbstractPage;

public abstract class OREditBillingOrganizationPage extends AbstractPage {

	public OREditBillingOrganizationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='processScheme']")
	protected WebElement TxtProcessingScheme;

	@FindBy(xpath = "//input[@id='effectDt']")
	protected WebElement getEffectDate;

	@FindBy(xpath = "//input[@id='custRefFmt1']")
	protected WebElement txtCustRefFmt1;

	@FindBy(xpath = "//input[@id='custRefFmt2']")
	protected WebElement txtCustRefFmt2;

	@FindBy(xpath = "//textarea[@id='custRefDesc']")
	protected WebElement txtCustRefDesc;

	@FindBy(xpath = "//textarea[@id='billdescription']")
	protected WebElement txtBillDescription;

	@FindBy(xpath = "//input[@id='accNo']")
	protected WebElement txtCreditPartyAccountNumber;

	@FindBy(xpath = "//span[@id='select2-bnkCode-container']")
	protected WebElement clkCreditorpartyBankName;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	protected WebElement txtCreditorpartyBankName;

	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	protected WebElement sltCreditPartyBankName;

	@FindBy(xpath = "//textarea[@id='rqstrCmts']")
	protected WebElement txtAreaRequesterComments;

	@FindBy(xpath = "//button[@id='submitBtn']")
	protected WebElement btnSubmit;

	@FindBy(xpath = "//button[@onclick='cnfmModalYes();']//span[contains(text(),'Yes')]")
	protected WebElement btnYesPopUp;

}
