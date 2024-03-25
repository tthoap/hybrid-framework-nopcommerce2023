package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_PartI extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		//1-Mở Url ra thì nó sẽ mở ra Home page, (Business page)
		driver = getBrowserDriver(browserName, url);

		homePage = new UserHomePageObject(driver);

		firstName = "John";
		lastName = "Henry";
		emailAddress = "Jh" + generateFakeNumber() + "@mail.us";
		password = "123456";
	}

	@Test
	public void User_01_Register_To_System() {
		//2- Từ Home page click vào Register link sẽ chuyển vào Register page
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");

		//3- Từ Register page click continue sẽ chuyển lại Home Page
		registerPage.clickToContinueButton();
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void User_02_Login_To_System() {
		//4- Từ HOme page chuyển về Login page
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		
		//5- Từ Login Page chuyển về Home Page
		loginPage.clickToLoginButton();
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void User_03_My_Account_Info() {
		//6- Từ Home page chuyển về Customer Info page
		homePage.clickToMyAccountLink();
		customerInfoPage = new UserCustomerInfoPageObject(driver);
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
