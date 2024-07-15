package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class MyAccountPage {
	private ElementUtils util;
	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	private By editAccountInformationPage = By.xpath("//a[contains(text(),'Edit your account information')]");
	
	private By firstNameValue = By.xpath("//input[@name='firstname']");
	
	private By lastNameValue = By.xpath("//input[@name='lastname']");
	
	private By email = By.xpath("//input[@name='email']");
	
	private By telephone = By.xpath("//input[@name='telephone']");
	
	private By myAccountLink = By.xpath("My Account");
	
	private By continueBtn = By.xpath("//a[contains(text(),'Continue')]");
	
	
	
	public String getfirstNameValue() {
		 return util.doGetElementText(firstNameValue);
	}
	
	public String getLastNameValue() {
		return util.doGetElementText(lastNameValue);
	}
	
	public String getemailValue() {
		return util.doGetElementText(email);
	}
	
	public String getTelephoneValue() {
		return util.doGetElementText(telephone);
	}
	
	
	public void clickAccountInfoPage() {
		util.waitForElementPresence(editAccountInformationPage, TimeUtil.DEFAULT_TIME_OUT);
		util.doClick(editAccountInformationPage);
	}
	
	public void clickContinueBtn() {
		util.doClick(continueBtn);
	}

}
