package com.stepdefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.MyAccountPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountSteps {

	MyAccountPage myaccount;
	WebDriver driver;

	public MyAccountSteps() {
		this.driver = DriverFactory.getDriver();
		myaccount = new MyAccountPage(driver);
	}

	@Then("user has successfully registered")
	public void the_user_has_successfully_registered() {
		myaccount.clickContinueBtn();
	}

	@When("user navigates to the My Information page")
	public void the_user_navigates_to_the_my_information_page() {
		myaccount.clickAccountInfoPage();
	}

	@Then("following details should be correctly displayed:")
	public void the_registration_details_should_be_correctly_displayed_on_the_my_information_page(DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		Map<String, String> expectedData = data.get(0);

		String expectedFirstName = expectedData.get("FirstName");
		String expectedLastName = expectedData.get("LastName");
		String expectedEmailValue = RegistrationSteps.emailValue;
		String expectedtelephone = expectedData.get("Telephone");

		Assert.assertEquals(myaccount.getfirstNameValue(), expectedFirstName);
		Assert.assertEquals(myaccount.getLastNameValue(), expectedLastName);
		Assert.assertEquals(myaccount.getemailValue(), expectedEmailValue);
		Assert.assertEquals(myaccount.getTelephoneValue(), expectedtelephone);

	}

	@Given("user login sucessfully and navigated to My Account page")
	public void user_login_sucessfully_and_navigates_to_My_Account_page() {
		Assert.assertTrue(myaccount.logoutBtnDisplayed());
	}

	@Then("following headers are displayed in my account page")
	public void followingMainHeaders(DataTable headersTable) {
		List<String> expected = headersTable.asList(String.class);
		List<String> actual = myaccount.followingh2menu();

		Assert.assertEquals(actual.toString(), expected.toString());
	}

	@Then("following aside menu are displayed")

	public void followingAsideMenuList(DataTable MenuTable) {
		List<String> expected = MenuTable.asList(String.class);
		List<String> actual = myaccount.followingAsideMenuList();
		Assert.assertEquals(actual.toString(), expected.toString());
	}

}
