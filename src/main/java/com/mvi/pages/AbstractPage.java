package com.mvi.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mvi.constants.BIZOPSUIConstants;
import com.mvi.enums.DropDown;
import com.mvi.enums.SelectStrategy;
import com.mvi.enums.WaitStrategy;

public abstract class AbstractPage {

	private static final Logger log = LoggerFactory.getLogger(AbstractPage.class);

	protected final WebDriver driver;
	protected final WebDriverWait wait;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		PageFactory.initElements(driver, this);
	}

	public abstract boolean isAt();

	public WebElement performExplicitWait(WaitStrategy waitstrategy, WebElement element) {
		WebElement resultElement = null;
		if (waitstrategy == WaitStrategy.CLICKABLE) {
			resultElement = new WebDriverWait(driver, BIZOPSUIConstants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(element));
		} else if (waitstrategy == WaitStrategy.PRESENCE) {
			resultElement = new WebDriverWait(driver, BIZOPSUIConstants.getExplicitwait())
					.until(ExpectedConditions.visibilityOf(element));
		} else if (waitstrategy == WaitStrategy.VISIBLE) {
			resultElement = new WebDriverWait(driver, BIZOPSUIConstants.getExplicitwait())
					.until(ExpectedConditions.visibilityOf(element));
		} else if (waitstrategy == WaitStrategy.NONE) {
			resultElement = element;
		}
		return resultElement;
	}

	protected void type(WebElement ele, WaitStrategy waitstrategy, String data) {
		WebElement element = performExplicitWait(waitstrategy, ele);
		element.clear();
		element.sendKeys(data);
	}

	public void typeAndTab(WebElement element, WaitStrategy waitstrategy, String data) {
		try {
			WebElement ele = performExplicitWait(waitstrategy, element);
			ele.clear();
			ele.sendKeys(data);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(WaitStrategy waitstrategy, WebElement ele) {
		WebElement element = performExplicitWait(waitstrategy, ele);
		element.click();
	}

	public void actions(WebElement ele, SelectStrategy selectStrategy) {
		Actions act = new Actions(driver);
		switch (selectStrategy) {
		case MOVETOELEMENT:
			act.moveToElement(ele).perform();
			break;
		case CLICK:
			act.click(ele).perform();
			break;
		default:
			break;
		}
	}

	public void selectDropDown(DropDown dropDown, WebElement dropdownElement, String value) {
		try {
			WebElement element = highLightElement(dropdownElement);
			Select sel = new Select(element);
			switch (dropDown) {
			case VALUE:
				sel.selectByValue(value);
				break;
			case VISIBLETEXT:
				sel.selectByVisibleText(value);
				break;
			default:
				log.info("Unsupported dropdown type: " + dropDown);
				break;
			}
		} catch (NullPointerException exception) {
			log.info("NullPointerException occurred while selecting dropdown: " + exception.getMessage());
		}
	}

	public WebElement highLightElement(WebElement webElement) {
		if (verifyDisplayed(webElement)) {
			scrollToElementUsingJSE(webElement);
			if (driver instanceof JavascriptExecutor) {
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid green'", webElement);
			}
		}
		return webElement;
	}

	public boolean verifyDisplayed(WebElement ele) {
		if (ele.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void scrollToElementUsingJSE(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public void selectValueFromDropDown(WebElement clickEle, WebElement typeEle, String data,
			WebElement clickAndSelectele) {
		try {
			ExpectedConditions.elementToBeClickable(clickEle);
			clickEle.click();
			ExpectedConditions.visibilityOf(typeEle);
			typeEle.clear();
			typeEle.sendKeys(data);
			ExpectedConditions.elementToBeClickable(clickAndSelectele);
			clickAndSelectele.click();
		} catch (Exception e) {
			log.info("Error occured on selectValueFromDropDown ");
		}
	}

	public boolean verifyExactText(WebElement ele, WaitStrategy waitstrategy, String expectedText) {
		boolean isMatched = false;
		WebElement element = performExplicitWait(waitstrategy, ele);
		String actualText = element.getText().trim();
		if (actualText.equals(expectedText)) {
			isMatched = true;
			log.info("Expected text :: " + expectedText + " :: matched with the actual text :: " + actualText);
		} else {
			log.info("Expected text ::" + expectedText + ":: not matched with the actual text :: " + actualText);
		}
		return isMatched;
	}

	public boolean verifyExactTextUsingValueAttribute(WebElement ele, WaitStrategy waitstrategy, String expectedText) {
		boolean isMatched = false;
		WebElement element = performExplicitWait(waitstrategy, ele);
		String actualText = element.getAttribute("value");
		if (actualText.equals(expectedText)) {
			isMatched = true;
			log.info("Expected text :: " + expectedText + " :: matched with the actual text :: " + actualText);
		} else {
			log.info("Expected text ::" + expectedText + ":: not matched with the actual text :: " + actualText);
		}
		return isMatched;
	}

	public boolean verifyAttributeValue(WebElement ele, WaitStrategy waitstrategy, String attribute, String value) {
		boolean isMatched = false;
		WebElement element = performExplicitWait(waitstrategy, ele);
		String actualAttribute = element.getAttribute(attribute);
		if (actualAttribute.equals(value)) {
			isMatched = true;
			log.info("Expected text ::" + value + " :: matched with the actual text :: " + actualAttribute);
		} else {
			log.info("Expected text ::" + value + " :: not matched with the actual text :: " + actualAttribute);
		}
		return isMatched;
	}

	public boolean verifyExtractedAttributeValue(WebElement element, WaitStrategy waitstrategy, String attribute,
			String value) {
		boolean isMatched = false;
		WebElement ele = performExplicitWait(waitstrategy, element);
		String actualAttribute = ele.getAttribute(attribute);
		String[] actualText = actualAttribute.split(":");
		String extractedValue = actualText[1].trim();
		if (extractedValue.equals(value)) {
			isMatched = true;
			log.info("Expected text ::" + value + " :: matched with the actual text :: " + extractedValue);
		} else {
			log.info("Expected text ::" + value + " :: not matched with the actual text :: " + extractedValue);
		}
		return isMatched;
	}

	public boolean verifySelectedText(WebElement ele, WaitStrategy waitstrategy, String expectedText) {
		boolean isMatched = false;
		WebElement element = performExplicitWait(waitstrategy, ele);
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String actualText = firstSelectedOption.getText().trim();
		if (actualText.equals(expectedText)) {
			isMatched = true;
			log.info("Expected text :: " + expectedText + " :: matched with the actual text :: " + actualText);
		} else {
			log.info("Expected text ::" + expectedText + ":: not matched with the actual text :: " + actualText);
		}
		return isMatched;
	}

}
