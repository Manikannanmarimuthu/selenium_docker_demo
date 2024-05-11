package com.mvi.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mvi.enums.DropDown;
import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORBillingOrganizationSearchPage;
import com.mvi.utils.Common;

public class BillingOrganizationSearchPage extends ORBillingOrganizationSearchPage {

	private static final Logger log = LoggerFactory.getLogger(BillingOrganizationSearchPage.class);

	public BillingOrganizationSearchPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.btnCreateBillingOrganization));
		return this.btnCreateBillingOrganization.isDisplayed();
	}

	public void enterUENAndClickSearchButton(String UEN) {
		type(this.txtUEN, WaitStrategy.VISIBLE, UEN);
		click(WaitStrategy.VISIBLE, this.btnSearch);
	}

	public void clickEditBillOrgDetailsIcon() {
		Common.wait(5);
		click(WaitStrategy.VISIBLE, this.iconEditBillOrgDetails);
	}

	public void clickViewBillOrgDetailsIcon() {
		Common.wait(5);
		click(WaitStrategy.VISIBLE, this.iconviewBillOrgDetails);
	}

	public void enterBillingOrgDetailsInUppercaseAndClickSearchBtn(String value, String UEN, String accountName) {
		selectDropDown(DropDown.VALUE, this.selectNoOfEntries, "100");
		if (value.equalsIgnoreCase("Uen")) {
			type(this.textUEN, WaitStrategy.VISIBLE, UEN.toUpperCase());
		} else if (value.equalsIgnoreCase("BillingOrg")) {
			type(textBillingOrg, WaitStrategy.VISIBLE, accountName.toUpperCase());
		}
		click(WaitStrategy.VISIBLE, this.btnSearch);
	}

	public boolean verifySearchResultsTable(String searchType, String arg2, String UEN, String accountName) {
		Common.wait(3);
		log.info("No of Entries :" + this.searchResultsTable.size());
		int uenLength = UEN.length();
		int boLenghth = accountName.length();
		String uen = null;
		String bo = null;
		List<Boolean> verifySearchResultsTable = new ArrayList<>();
		if (searchType.equalsIgnoreCase("Uen")) {
			if (arg2.equalsIgnoreCase("First")) {
				uen = UEN.substring(0, 3);
			} else if (arg2.equalsIgnoreCase("Last")) {
				uen = UEN.substring(uenLength - 3, uenLength);
			} else if (arg2.equalsIgnoreCase("Full")) {
				uen = UEN;
			}
			for (WebElement i : this.getSearchResultsUen) {
				String textUen = i.getText();
				if (textUen.contains(uen)) {
					log.info("Expected :: " + uen + " :: " + "Actual :: " + textUen );
					verifySearchResultsTable.add(true);
				}
			}
			
		} else if (searchType.equalsIgnoreCase("Billingorg")) {
			if (arg2.equalsIgnoreCase("First")) {
				bo = accountName.substring(0, 3);
			} else if (arg2.equalsIgnoreCase("Last")) {
				bo = accountName.substring(boLenghth - 3, boLenghth);
			} else if (arg2.equalsIgnoreCase("Full")) {
				bo = accountName;
			}
			for (WebElement i : this.getSearchResultsBillingOrg) {
				String textBo = i.getText();
				if (textBo.contains(bo)) {
					log.info("Actual :: " + textBo + " :: " + "Expected :: " + bo);
					verifySearchResultsTable.add(true);
				}
			}
		}
		boolean isAllTrue = verifySearchResultsTable.stream().allMatch(n -> n == true);
		return isAllTrue;
	}

	public void enterFirstThreeCharOfBillingOrgDetailsAndClickSearchBtn(String arg, String value) {
		selectDropDown(DropDown.VALUE, this.selectNoOfEntries, "100");
		if (arg.equals("Uen")) {
			type(this.textUEN, WaitStrategy.VISIBLE, value.substring(0, 3));
		} else if (arg.equalsIgnoreCase("BillingOrg")) {
			type(this.textBillingOrg, WaitStrategy.VISIBLE, value.substring(0, 3));
		}
		click(WaitStrategy.VISIBLE, this.btnSearch);
	}

	public void enterLastThreeCharOfBillingOrgDetailsAndClickSearchBtn(String arg, String value) {
		selectDropDown(DropDown.VALUE, this.selectNoOfEntries, "100");
		if (arg.equalsIgnoreCase("Uen")) {
			int uenLength = value.length();
			type(this.textUEN, WaitStrategy.VISIBLE, value.substring(uenLength - 3, uenLength));
		} else if (arg.equalsIgnoreCase("BillingOrg")) {
			int boLength = value.length();
			type(this.textBillingOrg, WaitStrategy.VISIBLE, value.substring(boLength - 3, boLength));
		}
		click(WaitStrategy.VISIBLE, this.btnSearch);
	}

	public void enterFirstThreeCharOfBillingOrgDetailsInUpperCase(String arg, String value) {
		selectDropDown(DropDown.VALUE, this.selectNoOfEntries, "100");
		if (arg.equalsIgnoreCase("Uen")) {
			String uenUpperCase = value.toUpperCase();
			type(this.textUEN, WaitStrategy.VISIBLE, uenUpperCase.substring(0, 3));
		} else if (arg.equalsIgnoreCase("BillingOrg")) {
			String boUpperCase = value.toUpperCase();
			type(this.textBillingOrg, WaitStrategy.VISIBLE, boUpperCase.substring(0, 3));
		}
		click(WaitStrategy.VISIBLE, this.btnSearch);
	}
	
	public void enterLastThreeCharOfBillingOrgDetailsInUpperCase(String arg,String value) {
		selectDropDown(DropDown.VALUE,this.selectNoOfEntries, "100");
		if (arg.equalsIgnoreCase("Uen")) {
			String uenUpperCase = value.toUpperCase();
			int Uenlength = uenUpperCase.length();
			type(this.textUEN,WaitStrategy.VISIBLE,uenUpperCase.substring(Uenlength - 3));
		} else if (arg.equalsIgnoreCase("BillingOrg")) {
			String boUpperCase = value.toUpperCase();
			int boLength = boUpperCase.length();
			type(this.textBillingOrg,WaitStrategy.VISIBLE,boUpperCase.substring(boLength - 3));
		}
		Common.wait(5);
		click(WaitStrategy.VISIBLE, this.btnSearch);
	}

}