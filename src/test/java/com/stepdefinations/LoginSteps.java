package com.stepdefinations;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private WebDriver driver;
	private LoginPage loginpage;
	private Properties prop;
	private Map<String, String> dbuserpwdValue;

	@Given("Navigate to login page")
	public void navigate_to_login_page() {
		loginpage = new LoginPage(driver);
		System.out.println("User navigated to login page");
	}

	@When("user enters the valid email address {string} into email text field")
	public void user_enters_the_valid_email_address_into_email_text_field(String email) {

		loginpage.enterEmail(email);

	}

	@When("user enters the valid password {string} into password text field")
	public void user_enters_the_valid_password_into_password_text_field(String password) {

		loginpage.enterPassword(password);

	}

	@When("click on Login button")
	public void click_on_Login_button() {

		loginpage.clickOnSubmitBtn();

	}

	@Then("user should be login successfully")
	public void user_should_be_login_successfully() {
		System.out.println("User should be login successfully");

		Assert.assertEquals("Login Sucessfull", loginpage.logoutBtnDisplayed());
	}

	@When("user enters the invalid email address {string} into email text field")
	public void user_enters_the_invalid_email_address_into_email_text_field(String invalidemail) throws Throwable {

		loginpage.enterEmail(invalidemail);

	}

	@And("user enters the invalid password {string} into password text field")
	public void user_enters_the_invalid_password_into_password_text_field(String invalidpassword) throws Throwable {

		loginpage.enterPassword(invalidpassword);

	}

	@Then("user should not be login successfully")
	public void user_should_not_be_login_successfully() throws Throwable {

		loginpage.clickOnSubmitBtn();

		if (loginpage.logoutBtnDisplayed()) {
			Assert.assertFalse(loginpage.logoutBtnDisplayed());
		}

	}

}
