package com.mvi.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mvi.pages.AbstractPage;

public abstract class ORHomePage extends AbstractPage {

		public ORHomePage(WebDriver driver) {
			super(driver);
		}
		
// Home Page		
		
	    @FindBy(xpath = "//span[@class='no-icon'][normalize-space()='Logout']")
	    protected WebElement logOutBtn;

	    @FindBy(xpath = "//span[normalize-space()='Yes']")
	    protected WebElement logOutConfirmationPopup;
	    

// Mandate Management - Billing Organization
		
	    @FindBy(xpath = "//span[normalize-space()='Mandate Management']")
	    protected WebElement menuMandates;
	    
	    @FindBy(xpath = "//span[text()='Billing Organization']")
	    protected WebElement subMenuBillingOrganization;
	    
	    @FindBy(xpath = "//span[text()='Review - Billing Organization']")
	    protected WebElement subMenuRevBillingOrganization;

}
