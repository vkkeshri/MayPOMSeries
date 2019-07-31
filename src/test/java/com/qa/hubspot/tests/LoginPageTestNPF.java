package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.LoginPageNPF;

public class LoginPageTestNPF {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPageNPF loginPageNpf;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPageNpf = new LoginPageNPF(driver);
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest(){
		String title = loginPageNpf.getLoginPageTitle();
		System.out.println("Login page title is : "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifySignUpLinkText(){
		Assert.assertTrue(loginPageNpf.verifySignUpLinkDisplayed());
	}
	
	@Test(priority = 3)
	public void loginTestWithCorrectCredentialsTest(){
		loginPageNpf.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}

}
