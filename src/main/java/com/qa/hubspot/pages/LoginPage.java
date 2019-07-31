package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class LoginPage extends BasePage {
	
	//1. page factory -- page objects
	@FindBy(id="username")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText="Sign Up")
	WebElement signUp;
	
	@FindBy(linkText="Show Password")
	WebElement showPassword;
	
	//2. Create the constructor of login page class and initialize your page objects
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3. Page Actions / Page Lib
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifySignUpLinkDisplayed(){
		return signUp.isDisplayed();
	}
	
	public HomePage doLogin(String username, String passwd){
		System.out.println("Credentials : "+username+"/"+passwd);
		email.sendKeys(username);
		password.sendKeys(passwd);
		loginButton.click();
		TimeUtil.mediumWait();
		
		return new HomePage(driver);
	}

}
