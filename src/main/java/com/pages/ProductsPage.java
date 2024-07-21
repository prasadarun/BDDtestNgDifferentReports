package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class ProductsPage {
	
	ElementUtils util;
	
	private By searchBox = By.xpath("//input[@type='text' and @name='search']");
	private By searchIcon = By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");
	private By productSearchResults = By.xpath("//div[@id='content']//h4/a");
	
	
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
	
	
	public List<String> getSearchResults(String productName) {	
		return  util.getElementsTextList(productSearchResults);
	}
	
	public List<String> getProductResults(){
		
		return util.getElementsTextList(productSearchResults);
		
		 
		
	}
	
	
	

}
