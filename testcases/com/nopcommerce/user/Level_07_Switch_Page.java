package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrderPageObject orderPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointpage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		//1-Mở Url ra thì nó sẽ mở ra Home page, (Business page)
		driver = getBrowserDriver(browserName, url);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "John";
		lastName = "Henry";
		emailAddress = "Jh" + generateFakeNumber() + "@mail.us";
		password = "123456";
	}

	@Test
	public void User_01_Register_To_System() {
		//2- Từ Home page click vào Register link sẽ chuyển vào Register page
		registerPage = homePage.clickToRegisterLink();

		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");

		//3- Từ Register page click continue sẽ chuyển lại Home Page
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login_To_System() {
		//4- Từ HOme page chuyển về Login page
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		
		//5- Từ Login Page chuyển về Home Page
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void User_03_My_Account_Info() {
		//6- Từ Home page chuyển về Customer Info page
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
		
	}
	
	@Test
	public void User_04_Navigate_Page() {
		//Customer Info Page -> Orders Page
		System.out.println("Customer Info Page -> Orders Page");
		orderPage = customerInfoPage.openOrderpage(driver);
		
		//Order Page -> Reward Point
		System.out.println("Order Page -> Reward Point");
		rewardPointpage = orderPage.openRewardPointPage(driver);
		
		//Reward Page -> Order Page
		System.out.println("Customer Info Page -> Orders Page");
		orderPage = rewardPointpage.openOrderpage(driver);
		
		//Order Page -> Customer Info Page
		System.out.println("Order Page -> Customer Info Pagen ");
		customerInfoPage = orderPage.openCustomerInfoPage(driver);
		
		// Customer Info Page -> Address Page
		System.out.println("Customer Info Page -> Address Page");
		addressPage = customerInfoPage.openAddressPage(driver);
		
		//Address Page -> Reward Point page
		System.out.println("Address Page -> Reward Point page");
		rewardPointpage = addressPage.openRewardPointPage(driver);
		
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
