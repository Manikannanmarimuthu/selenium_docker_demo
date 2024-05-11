package com.mvi.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mvi.pages.AbstractPage;

public abstract class ORLoginPage extends AbstractPage {

	public ORLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "loginIdStr")
	protected WebElement userName;

	@FindBy(id = "pwdStr")
	protected WebElement password;

	@FindBy(id = "btnLogin")
	protected WebElement login;

}
