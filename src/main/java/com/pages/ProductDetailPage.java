package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class ProductDetailPage {
	

	ElementUtils util;
	
	private By productHyperLink = By.xpath("//div[@class='caption']//a");
	
	
	public ProductDetailPage(WebDriver driver) {
		util = new ElementUtils(driver);
	}
	
	public void clickProductLink(String productName) {
		util.doClick(productHyperLink);
		util.waitForTitleContains(productName, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public boolean getAvailability(String status) {
		By availability = By.xpath("//li[contains(text(),'Availability: "+status+"')]");
		 util.doGetElementText(availability);
		 return util.doIsDisplayed(availability);
	}
	
	public boolean getProductCode(String code) {
		By prodcutCode = By.xpath("//li[contains(text(),'Product Code: "+code+"')]");
		util.doGetElementText(prodcutCode);
		return util.doIsDisplayed(prodcutCode);
	}
	
	
	
	
	
	

}
