package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class ProductDetailPage {
	

	ElementUtils util;
	
	private By productHyperLink = By.xpath("//div[@class='caption']//a");
	private By addToWhishList = By.xpath("(//button[@type='button']/i[@class='fa fa-heart'])[1]");
	private By sucessMsgAddToWishList = By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible");
	private By whishListMenu = By.id("wishlist-total");
	private By whishListMenuDescription = By.cssSelector("#content >h2");
	private By wishListTableColumns = By.cssSelector("table.table-bordered.table-hover > thead > tr >td");
	
	
	
	
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
	
	public void clickOnWhishList() {
		util.doClick(addToWhishList);
	}
	
	public String getsucessMsgAddToCart() {
		WebElement sucessMsg = util.waitForElementPresence(sucessMsgAddToWishList, TimeUtil.DEFAULT_TIME_OUT);
		String actualMsg = sucessMsg.getText();
		String actualMessage = actualMsg.replace("×", "").trim();
		return actualMessage;
	}
	
	public void clickWhishListMenu() {
		util.doClick(whishListMenu);
	}
	
	public List<String> getWishListProductsTableHeader() {
		util.waitForElementPresence(whishListMenuDescription, TimeUtil.DEFAULT_TIME_OUT);
		List<String> columns = util.getElementsTextList(wishListTableColumns);
		return columns;
		
	}
	
	public String getsucessMsgwishList() {
		WebElement sucessMsg = util.waitForElementPresence(sucessMsgAddToWishList, TimeUtil.DEFAULT_TIME_OUT);
		String actualMsg = sucessMsg.getText();
		String actualMessage = actualMsg.replace("×", "").trim();
		return actualMessage;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
