package com.pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	private By listOfMyAccount = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li/a");
	
	private By listOfMyOrders = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li/a");
	
	private By listOfMyAffliciateAccount = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[3]/li/a");
	
	private By listOfNewLetters = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[4]/li/a");
	
	private By listOfFooters = By.xpath("//div[@class='col-sm-3']/h5");
	
	private By footerInformationSubMenu = By.xpath("(//div[@class='col-sm-3']/h5)[1]/following::ul[@class='list-unstyled' and position()=1]/li/a");
	
	

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
	
	public List<String> getMyAccountSubMenu(){
		
		System.out.println("Actual output"+ util.getElementsTextList(listOfMyAccount));
		return util.getElementsTextList(listOfMyAccount);
	}
	
	public List<String> getMyOrdersubMenu(){
		return util.getElementsTextList(listOfMyOrders);
	}
	
	public List<String> getMyAffliciatesubMenu(){
		return util.getElementsTextList(listOfMyAffliciateAccount);
	}
	
	public List<String> getNewsubMenu(){
		return util.getElementsTextList(listOfNewLetters);
	}
	
	
	public boolean getReponseCodeForMyAccount() {
		return util.checkResponseCode(listOfMyAccount);
	}
	
	public List<String> getListOfFooterHeaders() {
		return util.getElementsTextList(listOfFooters);
	}
	
	public List<String> getfooterInformationSubMenu(){
		return util.getElementsTextList(footerInformationSubMenu);
	}
	
	public boolean getReponseCodeForInformationSubMenu() {
		return util.checkResponseCode(footerInformationSubMenu);
	}
	
}
