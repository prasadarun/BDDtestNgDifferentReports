package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class ProductsPage {

	ElementUtils util;
	private WebElement productHyperLink;

	private By searchBox = By.xpath("//input[@type='text' and @name='search']");
	private By searchIcon = By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");
	private By productSearchResults = By.xpath("//div[@id='content']//h4/a");
	private By productDesc = By.xpath("//div[@class='caption']/p[position()=1]");
	private By productPrice = By.xpath("//p[@class='price']");
	private By addToCart = By
			.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(),'Add to Cart')]");
	private By sucessMsg = By.xpath("//i[@class='fa fa-check-circle']");
	private By productLink = By
			.xpath("//i[@class='fa fa-check-circle']/following::a[contains(text(),'%s') and position()=1]");

	private By sucessMsgAddToCart = By.cssSelector("#product-search > div.alert.alert-success.alert-dismissible");

	private By pdpProductName = By.xpath("//div[@class='btn-group']/following::h1");

	public ProductsPage(WebDriver driver) {
		util = new ElementUtils(driver);
	}

	public void clickOnSearchBtn() {
		util.doClick(searchIcon);
	}

	public void enterProduct(String productName) {
		util.waitForElementPresence(searchBox, TimeUtil.DEFAULT_TIME_OUT);
		util.doSendKeys(searchBox, productName);
	}

	public List<String> getProductResults() {

		return util.getElementsTextList(productSearchResults);
	}

	public String getProductDesc() {
		return util.doGetElementText(productDesc).toString();
	}

	public String getPriceWithOutTax() {

		String totalPrice = util.doGetElementText(productPrice);
		String result = null;
		int index = totalPrice.indexOf("Ex ");
		if (index != -1) {
			result = totalPrice.substring(0, index).trim();
		} else {
			// Handle case where "Ex " is not found
			System.out.println("Substring not found.");
		}
		return result;
	}

	public String getPriceOnlyTax() {
		String totalPrice = util.doGetElementText(productPrice);
		String result = null;
		int lastIndex = totalPrice.length();

		int index = totalPrice.indexOf("Ex ");

		result = totalPrice.substring(index, lastIndex).trim();

		return result;
	}

	public String getsucessMsgAddToCart() {

		WebElement sucessMsg = util.waitForElementPresence(sucessMsgAddToCart, TimeUtil.DEFAULT_TIME_OUT);

		String actualMsg = sucessMsg.getText();

		String actualMessage = actualMsg.replace("×", "").trim();

		return actualMessage;
	}

	public boolean getProductNameLink(String productName) {

		WebElement sucessMsg = util.waitForElementPresence(sucessMsgAddToCart, TimeUtil.DEFAULT_TIME_OUT);

		productHyperLink = sucessMsg.findElement(By.linkText(productName));

		return productHyperLink.isDisplayed();

	}

	public boolean getShoppingCartLink() {

		WebElement sucessMsg = util.waitForElementPresence(sucessMsgAddToCart, TimeUtil.DEFAULT_TIME_OUT);
		WebElement shoppingCartLink = sucessMsg.findElement(By.linkText("shopping cart"));
		return shoppingCartLink.isDisplayed();
	}

	public void clickAddToCart() {
		util.doClick(addToCart);
	}

	public void clickProductLink() {
		productHyperLink.click();
	}

	public String getpdpProductName(String productName) {
		util.waitForElementsVisible(pdpProductName, TimeUtil.DEFAULT_TIME_OUT);
		return util.doGetElementText(pdpProductName);
	}

}
