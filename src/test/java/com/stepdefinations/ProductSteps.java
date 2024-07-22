package com.stepdefinations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.ProductsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

	ProductsPage product;
	WebDriver driver;

	public ProductSteps() {
		driver = DriverFactory.getDriver();
	}

	@When("the user logs in successfully and navigates to the My Account page")
	public void navigate_to_login_page() {
		product = new ProductsPage(driver);
	}

	@When("enters the product {string} in the search box")
	public void enter_product_in_SearchBox(String productName) {
		product.enterProduct(productName);
	}

	@And("clicks on the search button")
	public void clickOnSearchIcon() {
		product.clickOnSearchBtn();
	}

	@Then("I should see results related to {string}")
	public void getResults(String productName) {
		List<String> actualresults = product.getProductResults();
		System.out.println("actual Results" + actualresults.toString());
	}

	@Then("the results should include:")
	public void the_results_should_include(DataTable dataTable) {

		List<String> actualResults = product.getProductResults();

		// Normalize actual results (trim and convert to lower case)
		List<String> normalizedActualResults = actualResults.stream().map(result -> result.trim().toLowerCase())
				.collect(Collectors.toList());

		// Convert DataTable to a single string, then split into a list
		String expectedResultsString = dataTable.asLists(String.class).stream().flatMap(List::stream).findFirst()
				.orElse("");

		// Split the string by comma and trim each result
		List<String> expectedResultsList = Arrays.stream(expectedResultsString.split(","))
				.map(result -> result.trim().toLowerCase()).collect(Collectors.toList());

		// Check if all expected results are present in the actual results
		boolean allMatch = expectedResultsList.stream().allMatch(normalizedActualResults::contains);

		// Assert that all expected results are present
		Assert.assertTrue(allMatch,
				"Expected results: " + expectedResultsList + " but got: " + normalizedActualResults);

	}

	@Then("check the description of product:")
	public void decription_Of_Product(DataTable data) {

		String actual = product.getProductDesc();

		String expected = data.toString().replaceAll("^\\|\\s*|\\s*\\|$", "").trim();
		;

		Assert.assertEquals(actual, expected);

	}

	@Then("check the price of product without tax")
	public void checkPriceWithOutTax(DataTable data) {

		String actual = product.getPriceWithOutTax().toString();

		String expectedResultsString = data.asLists(String.class).stream().flatMap(List::stream).findFirst().orElse("");

		System.out.println("actual" + actual);
		System.out.println("expected" + expectedResultsString);

		Assert.assertEquals(actual, expectedResultsString);
	}

	@Then("check the price of product with tax")
	public void checkPriceWithTax(DataTable data) {
		String actual = product.getPriceOnlyTax().toString();

		String expectedResultsString = data.asLists(String.class).stream().flatMap(List::stream).findFirst().orElse("");

		System.out.println("actual" + actual);

		System.out.println("expected" + expectedResultsString);

		Assert.assertEquals(actual, expectedResultsString);

	}

	@And("click on addtocart button")
	public void clickAddToCart() {
		product.clickAddToCart();
	}

	@Then("validate the sucessMsg add to cart {string}")
	public void getsucessMsg(String expected) {
		String actual = product.getsucessMsgAddToCart().toString().trim();
		String expect = expected.toString().trim();

		Assert.assertEquals(actual, expect);
	}

	@Then("validate the productName shows in hyperlink {string}")
	public void hyperLinkProductName(String productName) {
		boolean isDisplayed = product.getProductNameLink(productName);

		Assert.assertTrue(isDisplayed);
	}

	@Then("validate the shopping cart link displayed")
	public void getShoppingCartLink() {
		boolean isDisplayed = product.getShoppingCartLink();

		Assert.assertTrue(isDisplayed);
	}

	@And("click on hyper link from sucess msg")
	public void clickLink() {
		product.clickProductLink();
	}

	@Then("user navigate to product detail page which displays the product header {string}")
	public void getpdpHeader(String productName) {
		String prodcutName = product.getpdpProductName(productName);
		String expectedName = product.toString().trim();

		Assert.assertEquals(prodcutName, expectedName);
	}

}
