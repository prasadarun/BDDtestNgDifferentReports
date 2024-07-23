package com.stepdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.ProductDetailPage;
import com.pages.ProductsPage;

import io.cucumber.java.en.*;

public class ProductDetaillSteps {
	
	private WebDriver driver;
	private ProductDetailPage productDetail;
	
	public ProductDetaillSteps() {
		driver = DriverFactory.getDriver();
		productDetail = new ProductDetailPage(driver);
	}

	@Given("user click on productLink {string} and navigated to product detail page")
	public void product_detail_page(String productName) {
		productDetail.clickProductLink(productName); 
	}
	
	@Then("validate the {string} of product")
	public void availabilityStatus(String status) {
		boolean b = productDetail.getAvailability(status);
		Assert.assertTrue(b);
	}
	
	
	@Then("validate the {string} code")
	public void prodcutCode(String code) {
		boolean b = productDetail.getProductCode(code);
		Assert.assertTrue(b);
	}
	
	

}
