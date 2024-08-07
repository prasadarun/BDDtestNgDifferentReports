package com.stepdefinations;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.ProductDetailPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	
	
	@When("user click on whishList menu")
	public void clickOnWishListMenu() {
		productDetail.clickOnWhishList();;
	}
	
	@Then("validate the table cloumns of wishListPage:")
	public void getCloumns(List<String> expectedColumns) {
		List<String> actual = productDetail.getWishListProductsTableHeader();
		List<String> expected = expectedColumns;
		Assert.assertEquals(actual, expected);
		
	}
	
	 @When("user click on wishListMenu from mainMenu")
	 public void clickWishListMenu() {
		 productDetail.clickWhishListMenu();
	 }
	 
	 @Then("validate the alertMsg add to cart {string}")
	 public void getsucessMsg(String expected) {
			String actual = productDetail.getsucessMsgAddToCart().toString().trim();
			String expect = expected.toString().trim();

			Assert.assertEquals(actual, expect);
		}
	
	 @Then("Validate the product details of wishList")
	 public void getDetails(List<String> expectedWishListItems) {
		 
		List<String> actual =  productDetail.getColumnDetails();
		
		List<String> expected = expectedWishListItems;
		
		Assert.assertEquals(actual,expected);
		
	 }
	 
	 @When("user click on review tab")
	 public void userclickOnReviewTab() {
		 
		 productDetail.clickOnReviewTab();
	 }
	 
	 @Then("validate the yourName text field should have following {string}")
	 public void assertYourName(String expectedYourName) {
		String actual =  productDetail.getYourName();
		String expected = expectedYourName;
		
		expected = expected.replace("\u00A0", " ").trim();
		actual = actual.replace("\u00A0", " ").trim();
		
		Assert.assertEquals(actual,expected);
	 }
	
	@Then("validate the tab heading text")
	public void getTabHeadings(List<String> expectedHeadingsText) {
		List<String> actual = productDetail.getHeadingActualText();
		Assert.assertEquals(actual, expectedHeadingsText);
	}
	
	
	@When("user submit rating with any value")
	public void submitRating() {
		productDetail.submitReview();
	}
	
	@Then("validate the error message will be displayed")
	public void assertAlertMsg() {
		Assert.assertTrue(productDetail.alertDisplayed());	
	}
	
	

}
