package com.mvi.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mvi.pages.AbstractPage;

public abstract class ORReviewBillingOrganizationSearchPage extends AbstractPage {

	public ORReviewBillingOrganizationSearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='UEN']")
	protected WebElement txtUEN;

	@FindBy(xpath = "//button[text()='Search']")
	protected WebElement btnSearch;

	@FindBy(xpath = "//button[@class='btn btn-fill btn-sm btn-success']")
	protected WebElement iconOpen;

}
