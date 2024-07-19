package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class ProductsPage {
	
	ElementUtils util;
	
	private By searchBox = By.xpath("//input[@type='text' and @name='search']");
	private By searchIcon = By.cssSelector("fa fa-search");
	
	
	public ProductsPage(WebDriver driver) {
		util = new ElementUtils(driver);
	}
	

	public void clickOnSearchBtn() {
		util.doClick(searchIcon);
	}


	public void enterProduct(String productName) {
		util.waitForElementPresence(searchBox, TimeUtil.DEFAULT_TIME_OUT);
		util.doSendKeys(searchBox,productName );
	}
	

}
