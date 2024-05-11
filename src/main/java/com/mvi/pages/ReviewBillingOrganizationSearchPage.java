package com.mvi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORReviewBillingOrganizationSearchPage;
import com.mvi.utils.Common;

public class ReviewBillingOrganizationSearchPage extends ORReviewBillingOrganizationSearchPage {

	public ReviewBillingOrganizationSearchPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.txtUEN));
		return this.txtUEN.isDisplayed();
	}

	public void enterUENAndClickSearchButton(String UEN) {
		type(this.txtUEN, WaitStrategy.VISIBLE, UEN);
		click(WaitStrategy.VISIBLE, this.btnSearch);
	}

	public void clickViewBillOrgDetailsIcon() {
		Common.wait(5);
		click(WaitStrategy.VISIBLE, this.iconOpen);
	}

}
