package com.stepdefinations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.RegistrationPage;
import com.utils.AppConstants;
import com.utils.ExcelUtil;
import com.utils.GenerateRandomString;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class RegistrationSteps {

	private RegistrationPage registrationpage;
	private WebDriver driver;
	private String emailValue;
	private String filePath = "src/test/resources/ExcelData/storeIds.xlsx";
	private String sheetName = "sheet1";
	
	@Given("navigate to home page")
	public void navigate_to_home_page() {
		this.driver = DriverFactory.getDriver();
		registrationpage = new RegistrationPage(driver);
	}

	@When("click on register option from aside menu")
	public void click_on_register_option_from_aside_menu() {
		System.out.println("registration driver" + driver);
		registrationpage.clickRegistrationLink();
	}

	@When("enter the following details")
	public void enter_the_following_details(DataTable dataTable) {

		List<List<String>> rows = dataTable.asLists(String.class);

		// Skip the header row
		for (List<String> row : rows.subList(1, rows.size())) {

			String firstName = row.get(0);
			String lastName = row.get(1);
			String email = row.get(2);
			String telephone = row.get(3);
			String password = row.get(4);
			String confirmpassword = row.get(5);

			System.out.println("firstName: " + row.get(0) + ", lastName " + row.get(1) + ", email: " + row.get(2)
					+ ", telephone: " + row.get(3) + ", password: " + row.get(4) + ", confirmpassword: " + row.get(5));

			if (firstName != null && lastName != null && telephone != null && password != null
					&& confirmpassword != null) {
				registrationpage.enterFirstName(firstName);
				registrationpage.enterLastName(lastName);
				registrationpage.enterPhone(telephone);
				registrationpage.enterPWD(password);
				registrationpage.enterConfirmPWD(confirmpassword);

				if (email.equals("empty") || email == null) {
					// nothing or handle empty email as per your requirement
					// If you want to skip entering email, you can leave this block empty
					System.out.println("email Value is empty");
				} else if (email.equals("dynamicvalue")) {
					emailValue = registrationpage.enterEmail(GenerateRandomString.generateRandomString() + "@gmail.com");
					System.out.println("email Value is dynamic");
				} else {
					System.out.println("One or more required values are null. Cannot proceed with registration.");
				}
			}
		}
	}

	@When("click on Subscribe option")
	public void click_on_subscribe_option() {
		registrationpage.clickSubscriptionButton();
	}

	@When("click on accept privacy button")
	public void click_on_accept_privacy_button() {

		registrationpage.clickPrivacyButton();
	}

	@When("click on continue button")
	public void click_on_continue_button() {
		registrationpage.clickContinueBtn();
	}

	@Then("user should be able to successfully create account")
	public void user_should_be_able_to_successfully_create_account() {
		Assert.assertEquals(registrationpage.isLoginSuccessful(), AppConstants.REGISTRATION_SUCCESSFULL);
	}
		
	@Then("store email and password into excel")
	public void store_email_and_password_into_excel() {
		
		System.out.println("Printing email Value"+emailValue);
		try {
			ExcelUtil e = new ExcelUtil(filePath, sheetName);
			e.writeStringToCell(emailValue);
			e.closeWorkbook();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	 
}
