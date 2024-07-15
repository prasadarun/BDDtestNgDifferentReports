package com.stepdefinations;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.MyAccountPage;
import com.pages.RegistrationPage;

import io.cucumber.java.en.*;

public class MyAccountSteps {
	

	MyAccountPage myaccount;
	WebDriver driver;
	
	public MyAccountSteps() {
		this.driver = DriverFactory.getDriver();
		myaccount = new MyAccountPage(driver);
	}
	
	@Given("user has successfully registered")
	public void the_user_has_successfully_registered() {
		myaccount.clickContinueBtn();
	}

	@When("user navigates to the My Information page")
	public void the_user_navigates_to_the_my_information_page() {
		myaccount.clickAccountInfoPage();
	}

	@Then("registration details should be correctly displayed on the My Information page")
	public void the_registration_details_should_be_correctly_displayed_on_the_my_information_page() {
	   System.out.println("balallal");
	}


}
