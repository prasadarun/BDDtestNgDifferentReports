package com.stepdefinations;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.ProductsPage;

import io.cucumber.java.en.*;

public class ProductSteps {
	
	ProductsPage product;
	WebDriver driver;
	
		public ProductSteps() {
			driver = DriverFactory.getDriver();
			product = new ProductsPage(driver);
			
		}
	
		@When("user enter the product {string} in searchbox")
		public void enter_product_in_SearchBox(String productName) {
			
			product.enterProduct(productName);
		}
		
		@And("click on search button")
		public void clickOnSearchIcon() {
			product.clickOnSearchBtn();
		}

}
