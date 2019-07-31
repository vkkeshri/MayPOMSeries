package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementActions extends BasePage{
	
	public ElementActions(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method is used to on the WebElement on the basis of given by locator 
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getElement(By locator){
		WebElement element = null;
		try{
			element = driver.findElement(locator);
		} catch (Exception e){
			System.out.println("Some exception occured while creating webelement "+locator);
		}
		return element;
	}
	
	public void waitForElementPresent(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForTitlePresent(String title){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
	}

	public boolean elementIsDisplayed(By locator){
		waitForElementPresent(locator);
		return getElement(locator).isDisplayed();
	}
	
	public void elementClick(By locator){
		getElement(locator).click();
	}
	
	public void elementSendKeys(By locator, String value){
		getElement(locator).sendKeys(value);
	}
	
	public String getPageTitle(){
		String title = null;
		try{
			title = driver.getTitle();
		} catch (Exception e){
			System.out.println("Some exception occured while getting the title "+title);
		}
		return title;
	}
}
