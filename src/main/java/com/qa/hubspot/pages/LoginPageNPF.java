package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;

public class LoginPageNPF extends BasePage {
	
	ElementActions elementActions;
	
	//1. Define locators: Page objects but without page factory
	By email = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.id("Sign Up");

	public LoginPageNPF(WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	//Page Actions:
	public String getLoginPageTitle(){
		elementActions.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE);
		return elementActions.getPageTitle();
	}
	
	public boolean verifySignUpLinkDisplayed(){
		return elementActions.elementIsDisplayed(signUpLink);
	}
	
	public HomePage doLogin(String username, String pwd){
		System.out.println("Credentials : "+username+" / "+pwd);
		elementActions.elementSendKeys(email, username);
		elementActions.elementSendKeys(password, pwd);
		elementActions.elementClick(loginButton);
		
		return new HomePage(driver);
	}
}
