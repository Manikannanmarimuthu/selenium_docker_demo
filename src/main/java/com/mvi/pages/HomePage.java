package com.mvi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.enums.SelectStrategy;
import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORHomePage;

public class HomePage extends ORHomePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.menuMandates));
		return this.menuMandates.isDisplayed();
	}

	public void logOutFromApp() {
		try {
			scrollToElementUsingJSE(logOutBtn);
			click(WaitStrategy.CLICKABLE, this.logOutBtn);
			click(WaitStrategy.CLICKABLE, this.logOutConfirmationPopup);
		} catch (Exception e) {
			WebElement ele = driver.findElement(By.xpath("//span[@class='no-icon'][normalize-space()='Logout']"));
			scrollToElementUsingJSE(ele);
			click(WaitStrategy.CLICKABLE, ele);
			WebElement ele2 = driver.findElement(By.xpath("//span[normalize-space()='Yes']"));
			click(WaitStrategy.CLICKABLE, ele2);
		}
	}

	public void navigateToBillingOrg() {
		click(WaitStrategy.CLICKABLE, this.menuMandates);
		actions(this.subMenuBillingOrganization, SelectStrategy.MOVETOELEMENT);
		actions(this.subMenuBillingOrganization, SelectStrategy.CLICK);
	}

	public void navigateToReviewBillingOrg() {
		click(WaitStrategy.CLICKABLE, this.menuMandates);
		actions(this.subMenuRevBillingOrganization, SelectStrategy.MOVETOELEMENT);
		actions(this.subMenuRevBillingOrganization, SelectStrategy.CLICK);
	}

}
