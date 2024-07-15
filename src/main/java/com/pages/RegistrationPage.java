package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class RegistrationPage {

	private ElementUtils util;

	public RegistrationPage(WebDriver driver) {
		util = new ElementUtils(driver);
		System.out.println("utils driver"+ driver);
	}

	private By myAccount = By.xpath("//span[contains(text(),'My Account')]");
	private By registerasideLink = By.xpath("//div[@class='list-group']/a[contains(text(),'Register')]");

	// Text fields data
	private By firstName = By.cssSelector("#input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']/input[@value='1' and @type='radio']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']/input[@value='0' and @type='radio']");

	// Error text labels

	private By firstNameErrorLabel = By.xpath(
			"//input[@name='firstname']//following::div[contains(text(),'First Name must be between 1 and 32 characters!')]");
	private By lastNameErrorLabel = By.xpath(
			"//input[@name='lastname']//following::div[contains(text(),'Last Name must be between 1 and 32 characters!')]");
	private By emailErrorLabel = By.xpath(
			"//input[@name='email']//following::div[contains(text(),'E-Mail Address does not appear to be valid!')]");
	private By telephoneErrorLabel = By.xpath(
			"//input[@name='telephone']//following::div[contains(text(),'Telephone must be between 3 and 32 characters!')]");
	private By passwordErrorLabel = By.xpath(
			"//input[@name='password']//following::div[contains(text(),'Password must be between 4 and 20 characters!')]");

	// Header text
	private By registerAccountTitle = By.cssSelector("div#content h1");
	private By yourpersonalDetails = By.cssSelector("fieldset#account>legend");
	private By yourpassword = By.cssSelector("fieldset:nth-child(2) legend");
	private By newsLetters = By.cssSelector("fieldset:nth-child(3) legend");
	private By privacyText = By.cssSelector("div.pull-right:nth-child(1)");

	// links
	private By loginPageLink = By.xpath("//a[contains(text(),'login page')]");
	private By privacyLink = By.cssSelector("a.agree1");
	private By privacyWindowText = By.xpath("//h4[contains(text(),'Privacy Policy')]");
	private By closePrivacyModel = By.cssSelector("button.close");

	private By registerSuccessMesg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public void clickRegistrationLink() {
		util.clickElementWhenReady(registerLink, TimeUtil.DEFAULT_TIME_OUT);
	}

	public void clickSubscriptionButton() {
		util.doClick(subscribeYes);
	}

	public void enterFirstName(String firstname) {

		util.doSendKeys(firstName, firstname);
	}

	public void enterLastName(String lastname) {
		util.doSendKeys(lastName, lastname);

	}

	public void enterPhone(String telePhone) {

		util.doSendKeys(telephone, telePhone);
	}

	public void enterPWD(String password1) {

		util.doSendKeys(password, password1);
	}

	public void enterConfirmPWD(String confirmpassword2) {
		util.doSendKeys(confirmpassword, confirmpassword2);

	}

	public String enterEmail(String email1) {
		util.doSendKeys(email, email1);
		return email1;

	}

	public void clickPrivacyButton() {
		util.doClick(agreeCheckBox);
	}

	public void clickContinueBtn() {
		util.doClick(continueButton);
	}

	public String isLoginSuccessful() {
		return util.doGetElementText(registerSuccessMesg);
	}
	
	


}
