package com.pages;

import java.util.List;

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

	private By firstNameValue = By.id("input-firstname");

	private By lastNameValue = By.id("input-lastname");

	private By email = By.id("input-email");

	private By telephone = By.id("input-telephone");

	private By myAccountLink = By.xpath("My Account");

	private By continueBtn = By.xpath("//a[contains(text(),'Continue')]");

	private By menuHeaders = By.xpath("//div[@id='content']/h2");

	private By asideMenuList = By.xpath("//a[@class='list-group-item']");

	private By logoutMenu = By.xpath("//a[@class='list-group-item' and contains(text(),'Logout')]");

	public String getfirstNameValue() {
		return util.doGetAttributeValue(firstNameValue, "value");
	}

	public String getLastNameValue() {
		return util.doGetAttributeValue(lastNameValue, "value");
	}

	public String getemailValue() {
		return util.doGetAttributeValue(email, "value");
	}

	public String getTelephoneValue() {
		return util.doGetAttributeValue(telephone, "value");
	}

	public void clickAccountInfoPage() {
		util.waitForElementPresence(editAccountInformationPage, TimeUtil.DEFAULT_TIME_OUT);
		util.doClick(editAccountInformationPage);
	}

	public void clickContinueBtn() {
		util.doClick(continueBtn);
	}

	public List<String> followingh2menu() {
		return util.getElementsTextList(menuHeaders);
	}

	public List<String> followingAsideMenuList() {
		return util.getElementsTextList(asideMenuList);
	}

	public boolean logoutBtnDisplayed() {
		return util.doIsDisplayed(logoutMenu);
	}

}
