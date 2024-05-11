package com.mvi.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mvi.pages.AbstractPage;

public abstract class ORBillingOrganizationSearchPage extends AbstractPage {

	public ORBillingOrganizationSearchPage(WebDriver driver) {
		super(driver);
	}

//	Billing Organization Search Page

	@FindBy(xpath = "//input[@id='UEN']")
	protected WebElement txtUEN;

	@FindBy(xpath = "//button[text()='Search']")
	protected WebElement btnSearch;
	
	@FindBy(xpath = "//button[@id='crtCBTRqstBtn']")
	protected WebElement btnCreateBillingOrganization;

	@FindBy(xpath = "//button[@class='btn btn-info btn-fill btn-sm']")
	protected WebElement iconEditBillOrgDetails;
	
	@FindBy(xpath = "//td//button[@class='btn btn-fill btn-sm btn-success']")
	protected WebElement iconviewBillOrgDetails;
	
	@FindBy(xpath = "//table[@id='billOrgMkrMainTbl']//tbody//tr")
	protected List<WebElement> searchResultsTable;

	@FindBy(css = "tr[role='row'] td:nth-child(2)")
	protected List<WebElement> getSearchResultsUen;
	
	@FindBy(css = "tr[role='row'] td:nth-child(3)")
	protected List<WebElement> getSearchResultsBillingOrg;
	
	@FindBy(xpath = "//select[@name='billOrgMkrMainTbl_length']")
	protected WebElement selectNoOfEntries;
	
	@FindBy(xpath = "//input[@id='UEN']")
	protected WebElement textUEN;
	
	@FindBy(xpath = "//input[@id='billOrg']")
	protected WebElement textBillingOrg;
}
