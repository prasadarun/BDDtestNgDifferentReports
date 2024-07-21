package com.stepdefinations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.ProductsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

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
		List<String> actualresults = product.getSearchResults(productName);
		System.out.println("actual Results" + actualresults.toString());
	}

	@Then("the results should include:")
	public void the_results_should_include(DataTable dataTable) {

		 List<String> actualResults = product.getProductResults();

		    // Normalize actual results (trim and convert to lower case)
		    List<String> normalizedActualResults = actualResults.stream()
		                                                        .map(result -> result.trim().toLowerCase())
		                                                        .collect(Collectors.toList());

		    // Convert DataTable to a single string, then split into a list
		    String expectedResultsString = dataTable.asLists(String.class).stream()
		                                             .flatMap(List::stream)
		                                             .findFirst()
		                                             .orElse("");
		    
		    // Split the string by comma and trim each result
		    List<String> expectedResultsList = Arrays.stream(expectedResultsString.split(","))
		                                             .map(result -> result.trim().toLowerCase())
		                                             .collect(Collectors.toList());


		    // Check if all expected results are present in the actual results
		    boolean allMatch = expectedResultsList.stream()
		                                           .allMatch(normalizedActualResults::contains);

		    // Assert that all expected results are present
		    Assert.assertTrue(allMatch, 
		        "Expected results: " + expectedResultsList + " but got: " + normalizedActualResults);

	}
}
