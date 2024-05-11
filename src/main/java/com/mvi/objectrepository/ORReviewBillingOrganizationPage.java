package com.mvi.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mvi.pages.AbstractPage;

public abstract class ORReviewBillingOrganizationPage extends AbstractPage {

	public ORReviewBillingOrganizationPage(WebDriver driver) {
		super(driver);
	}

//Checker Review Billing Organization Page	

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

	@FindBy(xpath = "//input[@id='billdescription']")
	protected WebElement getTxtBillingDescription;

	@FindBy(xpath = "//input[@id='UEN']")
	protected WebElement getTxtUen;

	@FindBy(xpath = "//input[@id='cretName']")
	protected WebElement getTxtAccountName;

	@FindBy(xpath = "//input[@id='accNo']")
	protected WebElement getTxtAccountNumber;

	@FindBy(xpath = "//input[@id='bnkCode']")
	protected WebElement getTxtBankName;

	@FindBy(xpath = "//input[@id='bicCd']")
	protected WebElement getTxtBankCode;

	@FindBy(xpath = "//textarea[@id='rqstrCmts']")
	protected WebElement getTxtRequesterComments;

	@FindBy(xpath = "//textarea[@id='rwrCmts']")
	protected WebElement txtRevCom;

	@FindBy(xpath = "//button[@id='approveBtn']")
	protected WebElement btnApprove;
	
	@FindBy(xpath = "//button[@id='rjctBtn']")
	protected WebElement btnReject;

	@FindBy(xpath = "//button[@onclick='cnfmModalYes();']//span[contains(text(),'Yes')]")
	protected WebElement btnYesPopUp;

// Billing Organization Previous value 	
	
    @FindBy(xpath = "//label[@id='effectDtHist']//following-sibling::i")
    protected WebElement effectiveDatePreviousValue; 

    @FindBy(xpath = "//label[@id='custRefFmt1Hist']//following-sibling::i")
    protected WebElement custRefformat1PreviousValue;
    
    @FindBy(xpath = "//label[@id='custRefFmt2Hist']//following-sibling::i")
    protected WebElement custRefformat2PreviousValue; 
    
    @FindBy(xpath = "//label[@id='custRefDescHist']//following-sibling::i")
    protected WebElement custRefDescriptionPreviousValue; 
    
    @FindBy(xpath = "//label[@id='billdescriptionHist']//following-sibling::i")
    protected WebElement billDescriptionPreviousValue; 
    
    @FindBy(xpath = "//label[@id='accNoHist']//following-sibling::i")
    protected WebElement creditPartyAccNoPreviousValue; 
    
    @FindBy(xpath = "//label[@id='bnkCodeHist']//following-sibling::i")
    protected WebElement creditPartyBankNamePreviousValue; 
}