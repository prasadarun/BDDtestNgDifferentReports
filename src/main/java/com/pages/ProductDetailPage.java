package com.pages;

import java.util.ArrayList;
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
	private By tableRowData = By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr");
	private By reviewTab = By.xpath("//a[contains(text(),'Reviews (0)')]");
	private By yourName = By.id("input-name");
	private By tabHeadings = By.xpath("//ul[@class='nav nav-tabs']/li");
	private By rating = By.xpath("//input[@type='radio' and @value ='4']");
	private By continueBtn = By.id("button-review");
	private By alertMsg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	
	
	
	public ProductDetailPage(WebDriver driver) {
		util = new ElementUtils(driver);
	}
	
	public void clickProductLink(String productName) {
		util.waitForElementPresence(productHyperLink, TimeUtil.DEFAULT_TIME_OUT);
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
	
	
	public List<String> getColumnDetails() {
		
		List<WebElement> rows = util.getElements(tableRowData);
		
        List<String> productDetailsList = new ArrayList<>();

		for (WebElement row : rows) {
		    // Locate all columns in the current row
		    List<WebElement> columns = row.findElements(By.tagName("td"));
		    
		    // Extract and print data from each column (td)
		    String productName = columns.get(1).getText(); // Product Name
		    String model = columns.get(2).getText();       // Model
		    String stock = columns.get(3).getText();       // Stock
		    String unitPrice = columns.get(4).getText();   // Unit Price
		    
		    String details = productName + "," + model + "," + stock + "," + unitPrice;
            
            // Add the formatted string to the list
            productDetailsList.add(details);
		}
		  
		 // String[] productDetailsArray = productDetailsList.toArray(new String[0]);
	        
	       for(String element:productDetailsList) {
	    	   System.out.println(element.toString());
	       }
	       return productDetailsList;
	    }
	
	public void clickOnReviewTab() {
		
		util.doClick(reviewTab);
	}
	
	public String getYourName() {
		return util.doGetAttributeValue(yourName, "value");
	}
	
	
	public List<String> getHeadingActualText(){
		return util.getElementsTextList(tabHeadings);
	}

	public void submitReview() {
		util.doClick(rating);
		util.doClick(continueBtn);
	}
	
	public boolean alertDisplayed() {
		util.waitForElementPresence(alertMsg, TimeUtil.DEFAULT_TIME_OUT);
		return util.doIsDisplayed(alertMsg);
	}
	
	
	
	
	
		
	}
	
	

