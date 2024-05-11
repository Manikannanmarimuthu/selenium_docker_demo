package com.mvi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mvi.enums.WaitStrategy;
import com.mvi.objectrepository.ORLoginPage;

public final class LoginPage extends ORLoginPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.userName));
		return this.userName.isDisplayed();
	}

	public void launchCIMBApp(String url) {
		this.driver.manage().window().maximize();
		this.driver.get(url);
	}

	public void loginAsMaker() {
		type(this.userName, WaitStrategy.VISIBLE, "cimbpsmaker");
		type(this.password, WaitStrategy.VISIBLE, "welcome123");
		click(WaitStrategy.VISIBLE, this.login);
	}

	public void loginAsChecker() {
		type(this.userName, WaitStrategy.VISIBLE, "cimbpschecker");
		type(this.password, WaitStrategy.VISIBLE, "welcome123");
		click(WaitStrategy.VISIBLE, this.login);
	}

}